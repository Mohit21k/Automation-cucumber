import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateReport
{
    private static final String outputDir = "./target/my-cucumber-reports";
    private static final String cucumberJson = "./target/cucumber-reports/cucumber.json";

    public static void main(String[] args)
    throws Exception
    {
        GenerateReport app = new GenerateReport();
        app.run();

    }

    public void run()
    throws Exception
    {
        File reportOutputDirectory = new File(outputDir);

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("./target/cucumber-reports/cucumber.json");

        String projectName = "Automated Testing with Sauce Labs";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;
        int buildNumber = 1;

        Configuration config = new Configuration(reportOutputDirectory, projectName);

        // optional config
        config.setParallelTesting(parallelTesting);
        config.setRunWithJenkins(runWithJenkins);
        config.setBuildNumber("" + buildNumber);

        // additional metadata presented on main page
//        config.addClassifications("Platform", "Windows");
//        config.addClassifications("Browser", "Firefox");
//        config.addClassifications("Branch", "release/1.0");

        // optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<>();
        classificationFiles.add("properties-1.properties");
//        classificationFiles.add("properties-2.properties");
        config.addClassificationFiles(classificationFiles);

        config.setTrendsStatsFile(new File("trends-stats-tmp.json"));

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
        Reportable result = reportBuilder.generateReports();

//        Trends trends = new Trends();
//        trends.addBuild("buildName", result);
    }

    public void run2()
    throws Exception
    {
        File reportOutputDirectory = new File(outputDir);

        List<String> jsonFiles = new ArrayList<>();

        File jsonDir = new File("./target/cucumber-reports");

        Pattern p = Pattern.compile("^cucumber.(\\d{14}).json$");

        File[] files = jsonDir.listFiles(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                Matcher m = p.matcher(name);
                if (m.find())
                {
                    jsonFiles.add(String.format("%s/%s", dir.getAbsolutePath(), name));
                }

                return false;
            }
        });

        String projectName = "Automated Testing with Sauce Labs";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;
        int buildNumber = 1;

        for (String jsonFile : jsonFiles)
        {
            Configuration config = new Configuration(reportOutputDirectory, projectName);

            // optional config
            config.setParallelTesting(parallelTesting);
            config.setRunWithJenkins(runWithJenkins);
            config.setBuildNumber("" + buildNumber);

            // additional metadata presented on main page
            config.addClassifications("Platform", "Windows");
            config.addClassifications("Browser", "Firefox");
            config.addClassifications("Branch", "release/1.0");

            // optionally add metadata presented on main page via properties file
            List<String> classificationFiles = new ArrayList<>();
            classificationFiles.add("properties-1.properties");
//        classificationFiles.add("properties-2.properties");
            config.addClassificationFiles(classificationFiles);

            config.setTrendsStatsFile(new File("trends-stats-tmp.json"));

            List<String> file = new ArrayList<String>();
            file.add(jsonFile);
            ReportBuilder reportBuilder = new ReportBuilder(file, config);
            Reportable result = reportBuilder.generateReports();

            buildNumber++;

//        Trends trends = new Trends();
//        trends.addBuild("buildName", result);
        }
    }
}
