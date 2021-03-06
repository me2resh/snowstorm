# Changelog
All notable changes to this project will be documented in this file.

This project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html). The change log format is inspired by [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## 2.2.3 Fix Release - 2019-04-23

### Fixes
- Fix concept descendants endpoint for stated and inferred.



## 2.2.2 Fix Release - 2019-04-01

### Improvements
- Clarify documentation for extension loading
### Fixes
- UK Edition import fixes



## 2.2.1 Fix Release - 2019-03-29

### Fixes
- FHIR API fix, remove Accept-Language for now, incompatible annotation



## 2.2.0 Release - 2019-03-15
Maintenance release with fixes and enhancements.

Thanks to everyone who raised an issue or provided a pull request for this maintenance release.

_NOTICE - The next major release will be 3.x which will introduce support
for SNOMED CT Editions with a completely axiom based stated form._

### Breaking
- Removal of partial support for concept search using ESCG in favour of ECL.

### Features
- Issue #14 Language/Extension support in FHIR API (PR from @goranoe).
  - Added module to CodeSystem lookup table to support this.
- Issue #18 Command line --exit flag shuts down Snowstorm after loading data.
- Added Elasticsearch basic authentication configuration options.
- Support for latest RF2 OWL reference set file naming.
- Added low level single concept endpoint.
- Added concept search definition status filter.

### Improvements
- Issue #28 Better non-english character support in ECL parsing (by @danka74).
- Docker configuration improvements and documentation (PRs from @Zwordi and @kevinbayes).
- Many documentation updates.
- New documentation on Snowstorm FHIR support.
- New documentation on updating extensions.
- Semantic index updates are not logged if they take less than a second.
- Added "Snowstorm startup complete" log message.
- Refactoring recommendations from lgtm.com.
- Allow branch specific MRCM XML configuration.
- Removed unused feature which allowed mirrored authoring via traceability feed.
- New ascii banner on startup.
- Concept search uses stated form unless inferred ecl given (better during authoring and has no effect on released content).
- Fail faster when concept page is above 10K (ES does not support this with default config).

### Fixes
- Issue #29 Escape concept term quotes in search results.
- Fix concept parents listing.
- Fix ECL dot notation against empty set of concepts.
- Fix ECL conjunction with reverse flag.
- MRCM API domain attributes returns 'is a' attribute if no parents specified.
- MRCM API allows subtypes of MRCM attributes.
- Fix reloading MRCM rules API mapping.
- Catch classification save error when branch locked.
- Fix missing destination expansion in relationship endpoint
- Prevent crosstalk in Elasticsearch integration tests.



## 2.1.0 Release - 2018-10-22

Snowstorm is now production ready as a read-only terminology server.

### Features
- Running with latest Elasticsearch server (6.4.2) is now tested recommended.
- Include Preferred Term (PT) in concepts returned from API.
- Translated content support.
  - Translated Fully Specified Name (FSN) and Preferred Term (PT) are returned
  against all API responses when language is set in the Accept-Language header.
- Add conceptActive filter to description search API.
- Search reference set members by mapTarget.

### Improvements
- Performance improvement when holding large change sets in MAIN branch.
- ReferenceComponent concept included in reference set member response.
- Creating import configuration checks branch path and code system.
- Better date formatting in branch created date and code system versions.
- Make concept lookup performance logging quieter.
- New flag to create code system version automatically during import.

### Fixes
- Inactive relationships excluded from integrity check.
- Correct path of Relationship API.
- Correct full integrity check branch mapping.
- Correct reference set member lookup branch mapping.
- Concept parents endpoint excludes inactive parent relationships.
- Allow creating code system on branches other than MAIN.
- RF2 import time logging calculation.
- Export configuration conceptsAndRelationshipsOnly defaults to false.



## 2.0.0 Release Candidate - 2018-09-19

This major version brings support for the new SNOMED Axiom component as well as
many productionisation fixes.

This version is ready for testing.

### Breaking
- Elasticsearch indexes must be recreated due to changes in their format.


### Features
- Support for new Axiom component type.
  - CRUD operations via concept browser format.
  - RF2 Import/Export.
  - Classification Service integration.
  - Axioms used in ECL queries against the stated form.
- New integrity check functions with API endpoints.
  - Runs automatically before promotion.
- Description search aggregations similar to SNOMED CT public browser.
  - Aggregations for module, semantic tag, language, concept reference set membership.
- Create Code Systems via REST API.
- Create Code System versions via REST API.
- All reference set members imported without the need for configuration.
- ICD, CTV3 and four MRCM reference sets added to default configuration for RF2 export.
- New released content RF2 patch API endpoint.

### Improvements
- Concurrency and branch locking improvements.
- Performance improvement for branches containing wide impacting semantic changes.
- Concept description search algorithm improvement.
- Classification Service client authentication.
- Component Identifier Service client authentication.
- Added support for ECL ancestor of wildcard.
- Update to latest Snomed Drools Engine version.
- Added software version API endpoint.
- Limit traceability logging to first 300 inferred changes.
- Allow microservices within the Snomed Single Sign-On gateway to access Snowstorm directly.
- Rows in RF2 delta only imported if effectiveTime is blank or greater than existing component.
- Concept search TSV download.
- Classification results TSV download.

### Fixes
- Many ECL fixes.
- Semantic index update fix for non "is a" relationships.
- Fixes for complete semantic index rebuild feature.
- Remove irrelevant concepts from branch merge review.
- Changes to axioms and historical associations included in conflict check.
- Bring pagination parameters in line with Snow Owl 5.x.
- Fix Authoring Form endpoint.
- Allow very large classification results to be saved.
- Fix classification status during save.
- Fix change type of classification results.
- Prevent unnecessary new versions of inactive language refset members.
- Fix RF2 export download headers.
- Better grouping and naming of API endpoints in Swagger interface.
- Set ELK as default reasoner in Swagger interface.
- Log traceability activity for branch merges.



## 1.1.0 Alpha - 2018-05-29
This second alpha release is another preview of Snowstorm in read-only mode.

### Breaking
- Elasticsearch indexes must be recreated due to changes in their format.

### Features
- Docker container option, see [Using Docker](docs/using-docker.md).

### Improvements
- Improved lexical search matching and sorting.
- Upgrade Snomed Drools validation engine.
- Improved CIS authentication.

### Fixes
- ECL fixes (some attributes were missing due to relationship sorting bug).
- MRCM endpoint pagination fix.



## 1.0.0 Alpha - 2018-04-12
This alpha release gives people an early preview of Snowstorm in read-only mode.
Just follow the setup guide and import a snapshot.

### Features
- Browsing concepts including all descriptions and relationships in one response.
- Concept search:
  - ECL 1.3 using inferred or stated form
  - Term filter using FSN
- Reference set member search.
