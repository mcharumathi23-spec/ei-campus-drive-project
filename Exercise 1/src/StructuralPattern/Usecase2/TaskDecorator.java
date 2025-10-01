package StructuralPattern.Usecase2;

public abstract class TaskDecorator extends ProjectComponent {
    protected ProjectComponent task;

    public TaskDecorator(ProjectComponent task) {
        super(task.name);
        this.task = task;
    }

    @Override
    public void display(int depth) {
        task.display(depth);
    }
}
