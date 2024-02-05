package com.andresefq.camunda.services;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.io.ByteArrayInputStream;
import java.io.File;

@Named
public class TranscoderService implements JavaDelegate {

    public static final String VIDEO_FORMAT = "HVEC";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String videoFormat = (String) delegateExecution.getVariable("videoFormat");
        ByteArrayInputStream video = (ByteArrayInputStream) delegateExecution.getVariable("video");

        if (!videoFormat.equals(VIDEO_FORMAT)) {
            // TODO transcode video
            videoFormat = VIDEO_FORMAT;
        }

        delegateExecution.setVariable("videoFormat", videoFormat);
    }
}
