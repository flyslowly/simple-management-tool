package main;

import java.util.Scanner;

public class Menu {
    private static final int MANAGE_PROJECT = 1;
    private static final int MANAGE_MEMBERS = 2;
    private static final int QUIT_1 = 3;

    private static final int PROJECT_NAME = 1;
    private static final int SV = 2;
    private static final int EV = 3;
    private static final int CV = 4;
    private static final int PROJECT_SCHEDULE = 5;
    private static final int RISK_MATRIX = 6;
    private static final int QUIT_2 = 7;

    private static final int SPENT_TIME_LIST = 1;
    private static final int MEMBER_PROJECT = 2;
    private static final int MEMBER_SPENT_TIME = 3;
    private static final int QUIT_3 = 4;

    private Scanner input;


    public Menu (){

        this.input = new Scanner(System.in);

    }



    public void run(Project project, Member[] members) {

        int option;
        do {
            printMenuOptions();
            System.out.print(" Type the option number: ");

            option = input.nextInt();
            input.nextLine(); //this skips the enter
            //that the user types after
            //typing the integer option.

            switch (option) {
                case MANAGE_PROJECT:

                    manageProject(project);

                    break;

                case MANAGE_MEMBERS:

                    manageMembers(members);

                    break;

                case QUIT_1:

                    break;

                default:

                    java.lang.System.out.println("Option "+option+" is not valid.");
                    java.lang.System.out.println();
                    break;
            }
        } while (option != QUIT_1);
    }

    private void manageProject(Project project){
        int option;
        do {
            printProjectMenuOptions();
            java.lang.System.out.print(" Type the option number: ");

            option = input.nextInt();
            input.nextLine(); //this skips the enter
            //that the user types after
            //typing the integer option.

            switch (option) {
                case PROJECT_NAME:

                    System.out.println("The project name is: " + project.getProjectName());

                    break;

                case SV:

                    System.out.println(project.getScheduleVariance().toString());

                    break;

                case EV:

                    System.out.println(project.getEarnedValue().toString());

                    break;

                case CV:

                    System.out.println(project.getCostVariance().toString());

                    break;

                case PROJECT_SCHEDULE:

                    project.showSchedule();

                    break;

                case RISK_MATRIX:

                    project.showRiskMatrix();

                    break;

                case QUIT_2:

                    break;

                default:

                    java.lang.System.out.println("Option "+option+" is not valid.");
                    java.lang.System.out.println();
                    break;
            }
        } while (option != QUIT_2);
    }


    private void manageMembers(Member[] members){
        int option;
        do {
            printMembersMenuOptions();
            System.out.print(" Type the option number: ");

            option = input.nextInt();
            input.nextLine(); //this skips the enter
            //that the user types after
            //typing the integer option.

            switch (option) {
                case SPENT_TIME_LIST:

                    showSpentTimeList(members);

                    break;

                case MEMBER_PROJECT:


                    showMemberProject(members);

                    break;

                case MEMBER_SPENT_TIME:

                    showMemberSpentTime(members);


                    break;

                case QUIT_3:

                    break;


                default:

                    java.lang.System.out.println("Option "+option+" is not valid.");
                    java.lang.System.out.println();
                    break;
            }
        } while (option != QUIT_3);
    }


    private void showSpentTimeList(Member[] members){
        System.out.println("Spent Time List:");
        for (Member member:members) {
            System.out.println(member.getId() + " " + member.getName()
            + " " + member.getTimeSpent() + "h.");
        }
    }

    private void showMemberProject(Member[] members){
        String id = readId();
        Member foundMember = retrieveMember(id, members);
        if(foundMember!=null){

            System.out.println(foundMember.getName() + " participates in "
                    + foundMember.getWorkProject().getProjectName() + ".");

        }else{

            System.out.println("A member of ID "+ id +" is not exit.");
        }

    }

    private void showMemberSpentTime(Member[] members){
        String id = readId();
        Member foundMember = retrieveMember(id, members);
        if(foundMember!=null){

            System.out.println(foundMember.getName() + " has spent "
                    + foundMember.getTimeSpent() + " hours.");

        }else{

            System.out.println("A member of ID "+ id +" is not exit.");
        }
    }


    public String readId(){

        System.out.print(" Type the ID of the employee（e.g.M3）: ");
        String id = input.nextLine();
        return id;
    }

    private void printMenuOptions() {
        System.out.println();
        java.lang.System.out.println(" === Welcome to Management Tool === ");
        java.lang.System.out.println(" Choose an option below: ");
        java.lang.System.out.println(" ");
        java.lang.System.out.println(" 1. Manage project. ");
        java.lang.System.out.println(" 2. Manage members. ");
        java.lang.System.out.println(" 3. QUIT. ");
        java.lang.System.out.println();
    }
    private void printProjectMenuOptions() {
        System.out.println();
        java.lang.System.out.println(" You want to manage project... ");
        java.lang.System.out.println(" Choose an option below: ");
        java.lang.System.out.println(" ");
        java.lang.System.out.println(" 1. Show Project Name. ");
        java.lang.System.out.println(" 2. Show Schedule Variance. ");
        java.lang.System.out.println(" 3. Show Earned Value. ");
        java.lang.System.out.println(" 4. Show Cost Variance. ");
        java.lang.System.out.println(" 5. Show Project Schedule. ");
        java.lang.System.out.println(" 6. Show Risk Matrix. ");
        java.lang.System.out.println(" 7. QUIT");
        java.lang.System.out.println();
    }
    private void printMembersMenuOptions() {
        System.out.println();
        java.lang.System.out.println(" You want to manage members... ");
        java.lang.System.out.println(" Choose an option below: ");
        java.lang.System.out.println(" ");
        java.lang.System.out.println(" 1. Show a list of spent time on the project of all members.");
        java.lang.System.out.println(" 2. Show a member's project.");
        java.lang.System.out.println(" 3. Show a member's spent time.");
        java.lang.System.out.println(" 4. QUIT");
        java.lang.System.out.println();
    }
    public void printMainWelcomeText(){
        System.out.println("Welcome to management tool!");
    }

    public Member retrieveMember(String id, Member[] members) {

        for(Member member: members){

            if(member.getId()!=null && member.getId().equals(id)){

                return member;

            }
        }
        return null;
    }

}
