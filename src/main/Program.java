package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Program {

    private Menu menu = new Menu();
    private Member[] members;
    private Project project;


    public Program(){
    }

    public void programStart() throws Exception{
        //show menu title
        menu.printMainWelcomeText();

        //Write and read the json file
        System.out.println("Creating data...");
        writeJsonProduct("product.json");
        System.out.println("Data created!");
        System.out.println("Reading data...");
        JSONObject product = (JSONObject) readJsonProduct("product.json");

        //transform risks
        JSONArray JSONrisks = (JSONArray) product.get("risks");
        Risk[]risks = new Risk[JSONrisks.size()];
        Iterator iterator_2 = JSONrisks.iterator();
        int index_2 = 0;
        while (iterator_2.hasNext()) {

            JSONObject risk = (JSONObject)iterator_2.next();
            String riskName = (String)risk.get("riskName");
            long probability = (long)risk.get("probability");
            long impact = (long)risk.get("impact");
            risks[index_2]= new Risk(riskName,(int)probability,(int)impact);
            index_2++;
        }

//        for (Risk risk:risks) {
//            risk.ShowRiskMatrix();
//        }

        //transform tasks
        JSONArray JSONtasks = (JSONArray)product.get("tasks");
        Task[]tasks = new Task[JSONtasks.size()];

        Iterator iterator_3 = JSONtasks.iterator();
        int index_3 = 0;
        while (iterator_3.hasNext()){

            JSONObject task = (JSONObject)iterator_3.next();
            String taskName = (String)task.get("taskName");
            long startWeek = (long)task.get("startWeek");
            long endWeek = (long)task.get("endWeek");
            tasks[index_3] = new Task(taskName,(int)startWeek,(int)endWeek);
            index_3++;
        }

//        for (Task task:tasks){
//            task.showSchedule();
//        }

        //transform Cost Variance, Earned Value and Schedule Variance
        JSONObject JSONcostVariance = (JSONObject) product.get("costVariance");
        long ACOW = (long)JSONcostVariance.get("ACOW");
        long BCOW = (long)JSONcostVariance.get("BCOW");
        CostVariance cv = new CostVariance(BCOW,ACOW);
//        cv.toString();

        JSONObject JSONearnedValue = (JSONObject)product.get("earnedValue");
        long BAC = (long)JSONearnedValue.get("BAC");
        double completedWork = (double)JSONearnedValue.get("completedWork");
        EarnedValue ev = new EarnedValue((double)BAC,completedWork);
//        ev.toString();

        JSONObject JSONscheduleVariance = (JSONObject)product.get("scheduleVariance");
        long BCOWP = (long)JSONscheduleVariance.get("BCOWP");
        long BCOWS = (long)JSONscheduleVariance.get("BCOWS");
        ScheduleVariance sv = new ScheduleVariance(BCOWP,BCOWS);
//        sv.toString();

        //Create product
        project = new Project((String) product.get("projectName"),risks,tasks,sv,ev,cv);



//        System.out.println(project.getProjectName());

        //transform members
        JSONArray JSONmembers = (JSONArray)product.get("members");
        members = new Member[JSONmembers.size()];

        Iterator iterator_1 = JSONmembers.iterator();
        int index_1 = 0;
        while (iterator_1.hasNext()) {

            JSONObject member = (JSONObject)iterator_1.next();
            String name = (String)member.get("name");
            String id = (String)member.get("id");
            long salaryPerHour = (long)member.get("salaryPerHour");
            long timeSpent = (long)member.get("timeSpent");
            members[index_1]= new Member(id,name,(int)salaryPerHour, project,(int)timeSpent);
            index_1++;
        }
//        for (Member member:members) {
//            member.showMemberInfo();
//        }

        System.out.println("Data reading complete!");

        menu.run(project,members);
    }

    @SuppressWarnings("unchecked")
    public static void writeJsonProduct(String fileName) throws Exception {

        JSONObject product = new JSONObject();
        product.put("projectName", "Work while Sleeping Assistant(WAC)");

        JSONArray members = new JSONArray();

        JSONObject member_1 = new JSONObject();
        member_1.put("name", "Xiang");
        member_1.put("id", "M1");
        member_1.put("salaryPerHour", 99);
        member_1.put("timeSpent", 10);

        JSONObject member_2 = new JSONObject();
        member_2.put("name", "Xuni");
        member_2.put("id", "M2");
        member_2.put("salaryPerHour", 99);
        member_2.put("timeSpent", 10);

        JSONObject member_3 = new JSONObject();
        member_3.put("name", "Chenyu");
        member_3.put("id", "M3");
        member_3.put("salaryPerHour", 99);
        member_3.put("timeSpent", 10);

        JSONObject member_4 = new JSONObject();
        member_4.put("name", "Erik");
        member_4.put("id", "M4");
        member_4.put("salaryPerHour", 99);
        member_4.put("timeSpent", 10);

        JSONObject member_5 = new JSONObject();
        member_5.put("name", "Nablo");
        member_5.put("id", "M5");
        member_5.put("salaryPerHour", 99);
        member_5.put("timeSpent", 10);

        JSONObject member_6 = new JSONObject();
        member_6.put("name", "Valentina");
        member_6.put("id", "M6");
        member_6.put("salaryPerHour", 99);
        member_6.put("timeSpent", 10);

        JSONObject member_7 = new JSONObject();
        member_7.put("name", "Trent");
        member_7.put("id", "M7");
        member_7.put("salaryPerHour", 99);
        member_7.put("timeSpent", 10);

        members.add(member_1);
        members.add(member_2);
        members.add(member_3);
        members.add(member_4);
        members.add(member_5);
        members.add(member_6);
        members.add(member_7);

        product.put("members", members);

        JSONArray risks = new JSONArray();
        JSONObject risk_1 = new JSONObject();
        risk_1.put("riskName", "Over budget");
        risk_1.put("probability", 2);
        risk_1.put("impact", 4);
        JSONObject risk_2 = new JSONObject();
        risk_2.put("riskName", "Operation errors");
        risk_2.put("probability", 3);
        risk_2.put("impact", 3);

        risks.add(risk_1);
        risks.add(risk_2);

        product.put("risks", risks);

        JSONArray tasks = new JSONArray();
        JSONObject task_1 = new JSONObject();
        task_1.put("taskName", "Write codes");
        task_1.put("startWeek", 3);
        task_1.put("endWeek", 7);
        JSONObject task_2 = new JSONObject();
        task_2.put("taskName", "Evaluation");
        task_2.put("startWeek", 6);
        task_2.put("endWeek", 8);

        tasks.add(task_1);
        tasks.add(task_2);

        product.put("tasks", tasks);

        JSONObject scheduleVariance = new JSONObject();
        scheduleVariance.put("BCOWP", 20000);
        scheduleVariance.put("BCOWS", 16000);
        JSONObject earnedValue = new JSONObject();
        earnedValue.put("completedWork", 0.5);
        earnedValue.put("BAC", 50000);
        JSONObject costVariance = new JSONObject();
        costVariance.put("BCOW", 50000);
        costVariance.put("ACOW", 40000);
        product.put("scheduleVariance", scheduleVariance);
        product.put("earnedValue", earnedValue);
        product.put("costVariance", costVariance);

        Files.write(Paths.get(fileName), product.toJSONString().getBytes());
    }

    public static Object readJsonProduct(String fileName) throws Exception {

        FileReader fileReader = new FileReader(fileName);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(fileReader);
    }


    public static void main(String... args)throws Exception{

        Program program = new Program();
        program.programStart();
    }



}
