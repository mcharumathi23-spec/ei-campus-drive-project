package StructuralPattern.Usecase2;

public class StatusDecorator extends TaskDecorator {
    private String status;

    public StatusDecorator(ProjectComponent task, String status) {
        super(task);
        this.status = status;
    }

    @Override
    public void display(int depth) {
        System.out.print("-".repeat(depth));
        System.out.println(" Task: " + task.name + " | Status: " + status);
    }
}

