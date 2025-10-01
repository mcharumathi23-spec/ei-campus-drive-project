package StructuralPattern.Usecase2;

public class ProjectFacade {
    private ProjectComponent rootProject;

    public ProjectFacade(String projectName) {
        rootProject = new Project(projectName);
    }

    public ProjectComponent getRootProject() {
        return rootProject;
    }

    public void addTask(ProjectComponent parent, ProjectComponent task) {
        parent.add(task);
    }

    public void displayProject() {
        rootProject.display(0);
    }
}

