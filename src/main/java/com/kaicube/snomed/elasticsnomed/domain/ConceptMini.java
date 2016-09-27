package com.kaicube.snomed.elasticsnomed.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaicube.snomed.elasticsnomed.rest.View;

import java.util.HashSet;
import java.util.Set;

import static com.kaicube.snomed.elasticsnomed.domain.Concepts.definitionStatusNames;

public class ConceptMini {

	private String conceptId;
	private Set<Description> activeFsns;
	private String definitionStatusId;
	private Boolean leafInferred;

	public ConceptMini() {
		activeFsns = new HashSet<>();
	}

	public ConceptMini(String conceptId) {
		this();
		this.conceptId = conceptId;
	}

	public ConceptMini(Concept concept) {
		this(concept.getConceptId());
		definitionStatusId = concept.getDefinitionStatusId();
	}

	public void addActiveFsn(Description fsn) {
		activeFsns.add(fsn);
	}

	@JsonView(value = View.Component.class)
	public String getConceptId() {
		return conceptId;
	}

	@JsonView(value = View.Component.class)
	public String getFsn() {
		return activeFsns.isEmpty() ? null : activeFsns.iterator().next().getTerm();
	}

	public void setDefinitionStatusId(String definitionStatusId) {
		this.definitionStatusId = definitionStatusId;
	}

	@JsonView(value = View.Component.class)
	public String getDefinitionStatus() {
		return definitionStatusNames.get(definitionStatusId);
	}

	public void setDefinitionStatus(String definitionStatusName) {
		definitionStatusId = definitionStatusNames.inverse().get(definitionStatusName);
	}


	@JsonView(value = View.Component.class)
	public Boolean getLeafInferred() {
		return leafInferred;
	}

	public ConceptMini setLeafInferred(Boolean leafInferred) {
		this.leafInferred = leafInferred;
		return this;
	}
}
