package io.logz;

import io.logz.model.Step;

import java.util.List;

/**
 * Author: Ivan Perepelytsya
 * Date: 12/3/19.
 */
public class PipelineDescriptor {
    private List<Step> steps;

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
