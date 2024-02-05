package com.andresefq.camunda.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.impl.json.jackson.JacksonJsonNode;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Named
public class CompareAudioLanguageService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        boolean isAudioLanguageCorrect = false;

        JacksonJsonNode assetLanguagesJson = (JacksonJsonNode) delegateExecution.getVariable("languages");
        List<String> assetLanguages = assetLanguagesJson.elements().stream().map(SpinJsonNode::stringValue).toList();

        String audioLanguage = (String) delegateExecution.getVariable("audioLanguage");

        for (String language : assetLanguages) {
            if (audioLanguage.equalsIgnoreCase(language)) {
                isAudioLanguageCorrect = true;
                break;
            }
        }

        delegateExecution.setVariable("isAudioLanguageCorrect", isAudioLanguageCorrect);
    }
}
