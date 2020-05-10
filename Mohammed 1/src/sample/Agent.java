package sample;

public class Agent {
    private static int AgentId = 0;
    private int id;
    private String username;
    private String password;

    public Agent(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static int getAgentId() {
        return AgentId;
    }

    public static void setAgentId(int agentId) {
        AgentId = agentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Agent "
               +  "id: " + id
               + ", username: " + username
               + ", password: " + password ;
    }
}
