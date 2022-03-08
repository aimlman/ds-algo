package array;

import java.util.*;

public class TournamentWinner {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        competitions.add(new ArrayList<>(Arrays.asList("HTML", "C#")));
        competitions.add(new ArrayList<>(Arrays.asList("C#", "Python")));
        competitions.add(new ArrayList<>(Arrays.asList("Python", "HTML")));

        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0,0,1));

        TournamentWinner obj = new TournamentWinner();
        String winner = obj.tournamentWinner(competitions, results);
        System.out.println("Winner: " + winner);

    }

    // Space: O(k), Time: O(n)
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        if (competitions == null || competitions.size() == 0) {
            return "";
        }

        HashMap<String, Integer> frequency = new HashMap<>();
        Integer maxPoints = 0;
        String winner = "";
        
        for (int i = 0; i < competitions.size(); i++) {
            Integer result = results.get(i);
            if (result.equals(1)) {
                // Home Team Won
                String team = competitions.get(i).get(0);
                Integer count = incrementFrequency(frequency, team);
                if (count > maxPoints) {
                    maxPoints = count;
                    winner = team;
                }
            } else {
                // Away Team Won
                String team = competitions.get(i).get(1);
                Integer count = incrementFrequency(frequency, team);
                if (count > maxPoints) {
                    maxPoints = count;
                    winner = team;
                }
            }
        }
        return winner;
    }

    private Integer incrementFrequency(HashMap<String, Integer> frequency, String team) {
        if (!frequency.containsKey(team)) {
            frequency.put(team, 3);
            return 1;
        } else {
            Integer count = frequency.get(team);
            frequency.put(team, count+3);
            return count+1;
        }
    }
    
}
