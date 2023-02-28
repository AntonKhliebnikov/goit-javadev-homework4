import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static void main(String[] args) {
//        List<MaxSalaryCountWorker> maxSalaryCountWorkers = new DatabaseQueryService().maxSalaryCountWorkers();
//        System.out.println(maxSalaryCountWorkers);

//        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().maxProjectCountClients();
//        System.out.println(maxProjectCountClients);

//        List<LongestProject> longestProjects = new DatabaseQueryService().longestProjects();
//        System.out.println(longestProjects);

//        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().youngestEldestWorkers();
//        System.out.println(youngestEldestWorkers);

        List<ProjectPrices> projectPrices = new DatabaseQueryService().projectPrices();
        System.out.println(projectPrices);

    }

    public List<ProjectPrices> projectPrices() {
        List<ProjectPrices> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("print_project_prices.sql"));
        Connection connection = Database.getInstance().getConnection();
        Statement st = connection.createStatement()) {

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String query = sb.toString();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                result.add(new ProjectPrices(name, price));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<YoungestEldestWorkers> youngestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("find_youngest_eldest_workers.sql"));
             Connection connection = Database.getInstance().getConnection();
             Statement st = connection.createStatement()) {

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String query = sb.toString();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                String birthday = rs.getString("birthday");
                result.add(new YoungestEldestWorkers(type, name, birthday));
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LongestProject> longestProjects() {
        List<LongestProject> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("find_longest_project.sql"));
             Connection connection = Database.getInstance().getConnection();
             Statement st = connection.createStatement()) {

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String query = sb.toString();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int mounthCount = rs.getInt("month_count");
                result.add(new LongestProject(name, mounthCount));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxProjectCountClient> maxProjectCountClients() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("find_max_projects_client.sql"));
             Connection connection = Database.getInstance().getConnection();
             Statement st = connection.createStatement()) {

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String query = sb.toString();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int clientId = rs.getInt("client_id");
                int projectCount = rs.getInt("COUNT(id)");
                result.add(new MaxProjectCountClient(clientId, projectCount));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<MaxSalaryCountWorker> maxSalaryCountWorkers() {
        List<MaxSalaryCountWorker> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("find_max_salary_worker.sql"));
             Connection connection = Database.getInstance().getConnection();
             Statement st = connection.createStatement()) {

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            String query = sb.toString();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                result.add(new MaxSalaryCountWorker(name, salary));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
