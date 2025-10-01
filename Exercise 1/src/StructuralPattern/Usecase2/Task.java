package StructuralPattern.Usecase2;

public class Task extends ProjectComponent {
    public Task(String name) {
        super(name);
    }

    @Override
    public void display(int depth) {
        System.out.println("-".repeat(depth) + " Task: " + name);
    }
}
