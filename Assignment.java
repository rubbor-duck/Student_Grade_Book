public class Assignment {
    private String name;
    private int totalPointsWorth;
    private int pointsEarned;

    public Assignment(String name, int totalPointsWorth)
        {
            this.name = name;
            this.totalPointsWorth = totalPointsWorth;
            pointsEarned = 0;
        }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getTotalPointsWorth()
    {
        return totalPointsWorth;
    }

    public void setTotalPointsWorth(int totalPointsWorth)
    {
        this.totalPointsWorth = totalPointsWorth;
    }

    public int getPointsEarned()
    {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned)
    {
        this.pointsEarned = pointsEarned;
    }
}
