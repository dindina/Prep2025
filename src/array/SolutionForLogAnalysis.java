package array;

import java.util.*;

class SolutionForLogAnalysis {
    public List<Integer> getStaleServerCount(int n, List<List<Integer>> logData, List<Integer> query, int x) {
        Map<Integer, List<Integer>> serverLogs = new HashMap<>();
        for (List<Integer> log : logData) {
            int serverId = log.get(0);
            int time = log.get(1);
            serverLogs.computeIfAbsent(serverId, k -> new ArrayList<>()).add(time);
        }

        // Sort the timestamps for each server
        for (List<Integer> times : serverLogs.values()) {
            Collections.sort(times);
        }

        List<Integer> result = new ArrayList<>();
        for (int q : query) {
            int startTime = q - x;
            int endTime = q;

            Set<Integer> activeServers = new HashSet<>();
            for (int serverId = 1; serverId <= n; serverId++) {
                List<Integer> times = serverLogs.getOrDefault(serverId, Collections.emptyList());
                if (binarySearchRange(times, startTime, endTime)) {
                    activeServers.add(serverId);
                }
            }

            result.add(n - activeServers.size());
        }

        return result;
    }

    private boolean binarySearchRange(List<Integer> times, int start, int end) {
        int left = 0, right = times.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int time = times.get(mid);
            if (time >= start && time <= end) {
                return true; // Found a time within the range
            } else if (time < start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // ... (main method remains the same)
}