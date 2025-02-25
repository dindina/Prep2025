package graph;


import java.util.*;

public class AccountMerge1 {
    public static void main(String[] args) {
        List<List<String>> acounts = new ArrayList<>();
        acounts.add(Arrays.asList("John","1","2"));
        acounts.add(Arrays.asList("John","1","3"));
        acounts.add(Arrays.asList("Mary","5"));
        acounts.add(Arrays.asList("John","6"));

        System.out.println(acounts);
        System.out.println("calling ");
        System.out.println(new AccountMerge1().accountsMerge(acounts));
    }

    private List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String,String> emailNameMap = new HashMap<>();
        Map<String , Set<String>> graph = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(List<String> nameAndEmails : accounts){

            String name = nameAndEmails.get(0);
            for(int i=1 ; i < nameAndEmails.size(); i++)
            {
                String email = nameAndEmails.get(i);
                if(!emailNameMap.containsKey(email))
                {
                    emailNameMap.put(email,name);
                    graph.put(email, new HashSet<>());
                }

                if(i==1) continue;
                String prevEmail =  nameAndEmails.get(i-1);
                graph.get(email).add(prevEmail);
                graph.get(prevEmail).add(email);

            }
        }
        System.out.println(graph);
        System.out.println(emailNameMap);
        Set<String> visited = new HashSet<>();
        for(String str : emailNameMap.keySet())
        {
            List<String> temp = new ArrayList<>();
            if(!visited.contains(str)) {
                visited.add(str);
                dfsAccount(str, graph, temp, visited);
                Collections.sort(temp);
                temp.add(0,emailNameMap.get(str));
                result.add(temp);
            }
        }


        return result;
    }

    private void dfsAccount(String str, Map<String, Set<String>> graph, List<String> temp, Set<String> visited) {
        temp.add(str);

        for(String email : graph.get(str)){
            if(!visited.contains(email)) {
                visited.add(email);
                dfsAccount(email, graph, temp, visited);
            }
        }
    }
}
