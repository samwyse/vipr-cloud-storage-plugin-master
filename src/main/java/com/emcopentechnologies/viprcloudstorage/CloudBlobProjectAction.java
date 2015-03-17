package com.emcopentechnologies.viprcloudstorage;

import java.util.List;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Run;

public class CloudBlobProjectAction implements Action {
	private final AbstractProject<?, ?> project;
	
	public CloudBlobProjectAction(AbstractProject<?, ?> project) {
		this.project = project;
	}

	public String getDisplayName() {
		return "Cloud Last Successful Artifacts";
	}

	public String getIconFileName() {
		return null;
	}

	public String getUrlName() {
		return null;
	}
	
	public int getLastSuccessfulBuildNumber() {
	    Run build = project.getLastSuccessfulBuild();
	    if (build == null) {
	        return 0;
	    }
	    return build.getNumber();
    }
	
	public CloudBlobAction getLastSuccessfulArtifactsAction() {
        Run build = project.getLastSuccessfulBuild();
        if (build == null) {
            return null;
        }
        
        List<CloudBlobAction> actions = build.getActions(CloudBlobAction.class);
        if (actions == null || actions.size() == 0) {
            return null;
        }
        return actions.get(actions.size() - 1);
    }
}
