public class Assignment {
    private String name;
    private String description;
    private int totalPointsWorth;
    private int pointsEarned;

    public Assignment(String name, String description, int totalPointsWorth)
        {
            this.name = name;
            this.description = description;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public float calcuatedGrade()
    {
        // Calculates grade based on 0.00 - 4.00 GPA grading scheme
        float grade;

        grade = ((float) pointsEarned / totalPointsWorth) * 4;

        return grade;
    }
}
