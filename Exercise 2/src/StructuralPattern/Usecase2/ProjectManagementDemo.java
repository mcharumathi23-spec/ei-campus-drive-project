package StructuralPattern.Usecase2;

public class ProjectManagementDemo {
    public static void main(String[] args) {
        ProjectFacade facade = new ProjectFacade("Corporate ERP System");

        ProjectComponent module1 = new Project("User Management Module");
        ProjectComponent module2 = new Project("Finance Module");

        ProjectComponent task1 = new Task("Create Login Feature");
        ProjectComponent task2 = new Task("Setup Roles & Permissions");
        ProjectComponent task3 = new Task("Implement Invoice System");
        ProjectComponent task4 = new Task("Generate Reports");

        // Add decorators
        task1 = new PriorityDecorator(task1, "High");
        task2 = new StatusDecorator(task2, "In Progress");
        task3 = new PriorityDecorator(new StatusDecorator(task3, "Pending"), "Medium");
        task4 = new StatusDecorator(task4, "Completed");

        // Build project hierarchy
        facade.addTask(module1, task1);
        facade.addTask(module1, task2);
        facade.addTask(module2, task3);
        facade.addTask(module2, task4);

        facade.addTask(facade.getRootProject(), module1);
        facade.addTask(facade.getRootProject(), module2);

        System.out.println("=== Corporate Project Management System ===\n");
        facade.displayProject();
    }
}
