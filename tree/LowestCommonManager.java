package tree;

import java.util.*;

public class LowestCommonManager {

    public static void main(String[] args) {
        var orgCharts = getOrgCharts();
        orgCharts
            .get('A')
            .addDirectReports(new LowestCommonManager.OrgChart[] {orgCharts.get('B'), orgCharts.get('C')});
        orgCharts
            .get('B')
            .addDirectReports(new LowestCommonManager.OrgChart[] {orgCharts.get('D'), orgCharts.get('E')});
        orgCharts
            .get('C')
            .addDirectReports(new LowestCommonManager.OrgChart[] {orgCharts.get('F'), orgCharts.get('G')});
        orgCharts
            .get('D')
            .addDirectReports(new LowestCommonManager.OrgChart[] {orgCharts.get('H'), orgCharts.get('I')});

            LowestCommonManager.OrgChart lcm =
            LowestCommonManager.getLowestCommonManager(orgCharts.get('A'), orgCharts.get('E'), orgCharts.get('I'));

            System.out.println(lcm.name);
    }

    public static HashMap<Character, LowestCommonManager.OrgChart> getOrgCharts() {
        var orgCharts = new HashMap<Character, LowestCommonManager.OrgChart>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
          orgCharts.put(a, new LowestCommonManager.OrgChart(a));
        }
        orgCharts.get('X').addDirectReports(new LowestCommonManager.OrgChart[] {orgCharts.get('Z')});
        return orgCharts;
      }

    // Time: O(n), Space: O(d)
    public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        OrgInfo orgInfo = getLCM(topManager, reportOne, reportTwo);
        if (orgInfo != null) {
            return orgInfo.manager;
        }
        return null;
    }

    public static OrgInfo getLCM(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
        int importantReportees = 0;
        for (OrgChart directReportee: manager.directReports) {
            OrgInfo orgInfo = getLCM(directReportee, reportOne, reportTwo);
            if (orgInfo.manager != null) return orgInfo;
            importantReportees += orgInfo.importantReportees;
        }
        if (manager == reportOne || manager == reportTwo) importantReportees++;
        OrgChart lcm = importantReportees == 2 ? manager : null;
        return new OrgInfo(lcm, importantReportees);
    }


    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<>();
        }

        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport: directReports) {
                this.directReports.add(directReport);
            }
        }
    }

    static class OrgInfo {
        public int importantReportees;
        public OrgChart manager;

        public OrgInfo(OrgChart manager, int importantReportees) {
            this.manager = manager;
            this.importantReportees = importantReportees;
        }
    }
    
}
