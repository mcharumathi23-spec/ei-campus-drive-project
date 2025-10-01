package StructuralPattern.Usecase2;

import java.util.ArrayList;
import java.util.List;

public class Project extends ProjectComponent {
    private List<ProjectComponent> components = new ArrayList<>();

    public Project(String name) {
        super(name);
    }

    @Override
    public void add(ProjectComponent component) {
        components.add(component);
    }

    @Override
    public void remove(ProjectComponent component) {
        components.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println("-".repeat(depth) + " Project: " + name);
        for (ProjectComponent component : components) {
            component.display(depth + 2);
        }
    }
}
