package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketSeedRootDto;
import softuni.exam.models.entity.Ticket;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.PlaneService;
import softuni.exam.service.TicketService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TicketServiceImpl implements TicketService {

    private static final String TICKET_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam3\\src\\main\\resources\\files\\xml\\tickets.xml";

    private final TicketRepository ticketRepository;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;
    private final PassengerService passengerService;
    private final PlaneService planeService;


    public TicketServiceImpl(TicketRepository ticketRepository, XmlParser xmlParser, ValidatorUtil validatorUtil, ModelMapper modelMapper, TownService townService, PassengerService passengerService, PlaneService planeService) {
        this.ticketRepository = ticketRepository;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
        this.passengerService = passengerService;
        this.planeService = planeService;
    }

    @Override
    public boolean areImported() {
        return ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKET_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(TICKET_FILE_PATH, TicketSeedRootDto.class).getTickets()
        .stream()
        .filter(ticketSeedDto -> {
            boolean isValid = validatorUtil.isValid(ticketSeedDto);

            sb.append(isValid
                    ? String.format("Successfully imported Ticket %s - %s",ticketSeedDto.getFromTown().getName(),ticketSeedDto.getToTown().getName())
                    :"Invalid Ticket").append(System.lineSeparator());

            return isValid;

        }).map(ticketSeedDto ->{
            Ticket ticket = modelMapper.map(ticketSeedDto, Ticket.class);


            ticket.setToTown(townService.getTownByName(ticketSeedDto.getToTown().getName()));
            ticket.setFromTown(townService.getTownByName(ticketSeedDto.getFromTown().getName()));
            ticket.setPassenger(passengerService.getPassengerByEmail(ticketSeedDto.getPassenger().getEmail()));
            ticket.setPlane(planeService.getPlaneByRegisterNumber(ticketSeedDto.getPlane().getRegisterNumber()));

            return ticket;
        }).forEach(ticketRepository::save);


        return sb.toString();
    }
}
