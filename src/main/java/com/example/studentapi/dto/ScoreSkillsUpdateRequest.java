package com.example.studentapi.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class ScoreSkillsUpdateRequest {

    @NotNull(message = "Programming score is required")
    @DecimalMin(value = "0.0", message = "Programming score cannot be below 0")
    @DecimalMax(value = "100.0", message = "Programming score cannot exceed 100")
    private Double programmingScore;

    @NotNull(message = "Mathematics score is required")
    @DecimalMin(value = "0.0", message = "Mathematics score cannot be below 0")
    @DecimalMax(value = "100.0", message = "Mathematics score cannot exceed 100")
    private Double mathematicsScore;

    private List<String> technicalSkills;

    public Double getProgrammingScore() {
        return programmingScore;
    }

    public void setProgrammingScore(Double programmingScore) {
        this.programmingScore = programmingScore;
    }

    public Double getMathematicsScore() {
        return mathematicsScore;
    }

    public void setMathematicsScore(Double mathematicsScore) {
        this.mathematicsScore = mathematicsScore;
    }

    public List<String> getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(List<String> technicalSkills) {
        this.technicalSkills = technicalSkills;
    }
}
