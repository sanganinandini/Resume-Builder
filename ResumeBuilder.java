import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Resume Class
class Resume {
    private String name;
    private String contact;
    private String address;
    private List<String> skills;
    private List<String> workExperience;
    private List<String> education;

    // Constructor
    public Resume(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.skills = new ArrayList<>();
        this.workExperience = new ArrayList<>();
        this.education = new ArrayList<>();
    }

    // Add skill
    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    // Add work experience
    public void addWorkExperience(String experience) {
        this.workExperience.add(experience);
    }

    // Add education
    public void addEducation(String edu) {
        this.education.add(edu);
    }

    // Display the resume
    public void displayResume() {
        System.out.println("\n-------------------- Resume --------------------");
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
        System.out.println("Address: " + address);
        System.out.println("Skills: ");
        skills.forEach(skill -> System.out.println("- " + skill));
        System.out.println("Work Experience: ");
        workExperience.forEach(exp -> System.out.println("- " + exp));
        System.out.println("Education: ");
        education.forEach(edu -> System.out.println("- " + edu));
        System.out.println("------------------------------------------------");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Resume resume = null;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nResume Builder Menu:");
            System.out.println("1. Create Resume");
            System.out.println("2. View Resume");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Safer input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Create Resume
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your contact number: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter your address: ");
                    String address = scanner.nextLine();
                    resume = new Resume(name, contact, address);

                    // Add skills
                    System.out.print("Enter skills (comma-separated): ");
                    String skillsInput = scanner.nextLine();
                    for (String skill : skillsInput.split(",")) {
                        resume.addSkill(skill.trim());
                    }

                    // Add work experience
                    System.out.print("Enter work experience (comma-separated): ");
                    String experienceInput = scanner.nextLine();
                    for (String experience : experienceInput.split(",")) {
                        resume.addWorkExperience(experience.trim());
                    }

                    // Add education
                    System.out.print("Enter education (comma-separated): ");
                    String educationInput = scanner.nextLine();
                    for (String edu : educationInput.split(",")) {
                        resume.addEducation(edu.trim());
                    }

                    System.out.println("\nResume created successfully!");
                    break;

                case 2:
                    // View Resume
                    if (resume != null) {
                        resume.displayResume();
                    } else {
                        System.out.println("No resume created yet. Please create one first.");
                    }
                    break;

                case 3:
                    // Exit
                    isRunning = false;
                    System.out.println("Exiting the Resume Builder. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }
}
