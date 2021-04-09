package ExamPreparation_1.viceCity.models.guns;
//created by J.M.

public interface Gun {

    String getName();

    int getBulletsPerBarrel();

    boolean canFire();

    int getTotalBullets();

    int fire();
}
