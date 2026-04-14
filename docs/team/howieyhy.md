# Howie Yeo Hao Yu - Project Portfolio Page

## Overview

ExpensiveLeh is a CLI for managing your personal finances. Users can indicate their budget and add expenses into the app to track their budget situation. Features include expense management, budgeting, loans, bookmarks, and comprehensive search functionality.

## Summary of Contributions

### Code contributed

[[RepoSense Link]](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=HowieYHY&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=HowieYHY&tabRepo=AY2526S2-CS2113-W11-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code&authorshipIsIgnoredFilesChecked=false)

### Enhancements implemented

**New feature:** Designed Expense Superclass
- Created abstract `Expense` superclass with polymorphic support for different expense types (Food, Transport, Groceries, Others)
- Extended `Loan` class to inherit from `Expense`, enabling unified handling of both expenses and loans

**New feature:** Comprehensive Search Function
- Implemented keyword-based search across both expenses and loans with case-insensitive matching
- Implemented `searchByKeywordWithIndices()` in `ExpenseManager` to preserve actual indices in search results
- Created `searchByKeyword()` method in `LoanManager` for parallel searching

**Bug Fix:** Search Result Index Mismatch
- Fixed bug where search results displayed incorrect indices, causing delete/edit commands to target wrong expenses
- Modified `SearchCommand` to display actual expense indices from the original list

**Enhancement:** UML Diagram Standardization
- Audited and updated 8+ UML class diagrams to comply with standard UML 2.0 notation
- Replaced non-standard notation (custom labels like "uses >", "manages >", "outputs to >") with standard UML arrows and multiplicity notation

### Contributions to the User Guide

- Documented `add`, `edit`, `delete` commands with examples for expenses, loans, and bookmarks
- Documented `list` command showing all types (expenses, loans, bookmarks, budgets)
- Documented `search` command with examples for expense-only, loan-only, and mixed searches
- Documented `help` command with FAQ section

### Contributions to the Developer Guide

- Documented Expense Superclass design and inheritance hierarchy
- Documented ExpenseManager class methods and responsibilities
- Documented Search Feature with dual-manager architecture
- Created UML diagrams: `Expense.puml`, `SearchCommandDiagram.puml`

### Contributions to team-based tasks

- Tested search feature with search-by-keyword test cases
- Fixed checkstyle violations in multiple files
- Reviewed and approved multiple pull requests before merging

### Review/mentoring contributions

- Reviewed pull requests for search feature implementation
- Corrected UML diagrams for CS2113 compliance
- Verified documentation accuracy in User Guide and Developer Guide

### Contributions beyond the project team

- Identified and documented 11 bugs in another team's project:
  - Command recognition failures (confirm command not recognized outside conversion context)
  - UI assist mode handling of multi-line input
  - Zero-amount transaction validation
  - Invalid date handling (Feb 31st silently corrected instead of rejected)
  - Silent fallback exchange rates without user notification
  - Case-sensitive account names (violates accounting standards)
  - Negative posting amounts (violates accounting semantics)
  - Duplicate command flags silently ignored
  - Decimal precision rounding not documented
