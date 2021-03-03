# USE CASE: 21 Produce a Report on the top N populated capital cities in a continent where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an urban city planner, I need a list of the top N populated capital cities in a continent where N is provided by the user to assist with the development of housing.

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current country population data. User supplies N.

### Success End Condition

The group is able to provide a sufficient report.

### Failed End Condition

No report is produced.

### Primary Actor

Urban City planner

### Trigger

Statistics are requested for population.

## MAIN SUCCESS SCENARIO

1. population information requested.
2. current population information extracted.
3. report provided to the urban city planner.

## EXTENSIONS

1. **Missing data**:
   1. inform urban city planner the data is missing.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0