package org.orcid.pojo.ajaxForm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.orcid.jaxb.model.clientgroup.GroupType;
import org.orcid.jaxb.model.clientgroup.OrcidClientGroup;

public class Group implements ErrorsInterface, Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> errors = new ArrayList<String>();
    private Text type;
    private Text groupOrcid;
    private Text groupName;
    private Text email;

    @Override
    public List<String> getErrors() {
        return errors;
    }

    @Override
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public OrcidClientGroup toOrcidClientGroup() {
        OrcidClientGroup orcidClientGroup = new OrcidClientGroup();
        orcidClientGroup.setType(GroupType.fromValue(getType().getValue()));
        orcidClientGroup.setGroupName(getGroupName().getValue());
        orcidClientGroup.setEmail(getEmail().getValue());
        return orcidClientGroup;
    }

    public Text getType() {
        return type;
    }

    public void setType(Text type) {
        this.type = type;
    }

    public Text getGroupOrcid() {
        return groupOrcid;
    }

    public void setGroupOrcid(Text groupOrcid) {
        this.groupOrcid = groupOrcid;
    }

    public Text getGroupName() {
        return groupName;
    }

    public void setGroupName(Text groupName) {
        this.groupName = groupName;
    }

    public Text getEmail() {
        return email;
    }

    public void setEmail(Text email) {
        this.email = email;
    }
}
