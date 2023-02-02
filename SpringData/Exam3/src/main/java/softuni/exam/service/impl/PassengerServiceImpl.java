package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerSeedDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static final String PASSENGER_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam3\\src\\main\\resources\\files\\json\\passengers.json";

    private final PassengerRepository passengerRepository;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;

    public PassengerServiceImpl(PassengerRepository passengerRepository, Gson gson, ValidatorUtil validatorUtil, ModelMapper modelMapper, TownService townService) {
        this.passengerRepository = passengerRepository;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {

        StringBuilder sb = new StringBuilder();
        Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class))
                .filter(passengerSeedDto -> {
                    boolean isValid = validatorUtil.isValid(passengerSeedDto);
                    sb.append(isValid
                            ? String.format("Successfully imported Passenger %s - %s", passengerSeedDto.getLastName(), passengerSeedDto.getEmail())
                            : "Invalid Passenger").append(System.lineSeparator());

                    return isValid;
                }).map(passengerSeedDto -> {
            Passenger passenger = modelMapper.map(passengerSeedDto, Passenger.class);
            Town town = townService.getTownByName(passengerSeedDto.getTown());
            passenger.setTown(town);

            return passenger;
        }).forEach(passengerRepository::save);


        return sb.toString();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();
        List<Passenger> allPassengers = passengerRepository.findAllPassengers();
        allPassengers.forEach(passenger -> {
            sb.append(String.format("Passenger %s  %s\n" +
                            "\tEmail - %s\n" +
                            "\tPhone - %s\n" +
                            "\tNumber of tickets - %d\n" +
                            ". . . \n"
                    , passenger.getFirstName()
                    , passenger.getLastName()
                    , passenger.getEmail()
                    , passenger.getPhoneNumber()
                    , passenger.getTickets().size()))
                    .append(System.lineSeparator());

        });
        return sb.toString();
    }

    @Override
    public Passenger getPassengerByEmail(String email) {
        return passengerRepository.getPassengerByEmail(email).orElse(null);
    }
}
