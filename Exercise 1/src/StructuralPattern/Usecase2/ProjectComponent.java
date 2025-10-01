package StructuralPattern.Usecase2;

public abstract class ProjectComponent {
    protected String name;

    public ProjectComponent(String name) {
        this.name = name;
    }

    public void add(ProjectComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(ProjectComponent component) {
        throw new UnsupportedOperationException();
    }

    public abstract void display(int depth);
}

