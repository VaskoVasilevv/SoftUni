package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Team;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    Optional<Team> getTeamByNameAndPicture_Url(String name, String picture_url);
    Optional<Team> getTeamByName(String name);

    boolean existsTeamByName(String name);
}
