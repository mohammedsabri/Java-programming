package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;

public class AgentModel {


    private ArrayList<Agent> agents;



    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void setAgents(ArrayList<Agent> agent) {
        this.agents = agents;
    }

    public AgentModel() {
        agents = new ArrayList<Agent>();
    }



    public void addAgent(int id,String username, String password) {
        Agent agent = new Agent(id,username, password);
        agents.add(agent);
    }


    //This method returns the index number and the title of each

    //element in the Agent ArrayList.

    public String ListAgents() {

        int i = 0;
        String displayAgents = "All  Agents";
        for (Agent item : agents) {
            displayAgents += "\n" + (i++) + ": " + item;
        }
        return displayAgents;

    }

    public void saveAgents() throws Exception {


        XStream xStream = new XStream(new DomDriver());
        ObjectOutputStream out = xStream.createObjectOutputStream
                (new FileWriter("agents.xml"));
        out.writeObject(agents);
        out.close();
    }

    public void loadAgents() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
                (new FileReader("agents.xml"));
        agents = (ArrayList<Agent>) is.readObject();
        is.close();

    }


    public void DeleteAgents(int id) {
        agents.remove(id);
    }


    public Agent getAgentDetails(String id) {

        try {
            int id1 = (Integer.parseInt(id));  //Test only


            for (Agent item : agents) {

                if (item.getId() == id1) {

                    return item;

                }

            }
        } catch (Exception e) {

        }
        return null;

    }

    public int getSize(){
        return agents.size();
    }

    public void addToListBox(ListView lstView) {
        lstView.getItems().clear();
        for (int i = 0; i < agents.size(); i++) {
            lstView.getItems().add(agents.get(i));

        }
    }



}
