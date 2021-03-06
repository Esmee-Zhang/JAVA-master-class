package GenericChallenge;

import GenaricExample.Player;

import java.util.ArrayList;

/**
 * @author Esmee Zhang
 * @date 7/9/20 6:00 下午
 * @projectName JAVA-master-class
 */
public class Team<T extends Player> implements Comparable<Team<T>>{//& Coach & Manager> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tried = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName() + "is already on this team");
            return false;
        }else{
            members.add(player);
            System.out.println(player + "picked for team" + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        if(ourScore > theirScore){
            won ++;
        }else if(ourScore == theirScore){
            tried ++;

        }else{
            lost ++;
        }
        played++;
        if(opponent != null){
            opponent.matchResult(null, theirScore, ourScore);
        }

    }

    public int ranking(){
        return(won + 2) + tried;
    }

    public int compareTo(Team<T> team){
        if(this.ranking()> team.ranking()){
            return -1;
        }else if(this.ranking() < team.ranking()){
            return 1;

        }else{
            return 0;
        }
    }

}
