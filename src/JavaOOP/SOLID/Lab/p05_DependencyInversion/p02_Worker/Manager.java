package JavaOOP.SOLID.Lab.p05_DependencyInversion.p02_Worker;

public class Manager extends Worker{
private Worker worker;
    public Manager(Worker worker) {
         this.worker = worker;
    }
}
