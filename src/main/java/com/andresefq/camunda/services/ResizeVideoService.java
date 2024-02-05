package com.andresefq.camunda.services;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.ByteArrayInputStream;
import java.io.File;

@Named
public class ResizeVideoService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        ByteArrayInputStream video = (ByteArrayInputStream) delegateExecution.getVariable("video");
        // TODO Resize video logic
        String videoSize = "HD";
        delegateExecution.setVariable("size", videoSize);
    }
}
