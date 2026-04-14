# Zhang Yize - Project Portfolio Page

## Overview

ExpensiveLeh is a CLI for managing your personal finances. Users can indicate their budget and add expenses into the app to track their budget situation.
Features include expense management, budgeting, loans, bookmarks, and search functionality.

## Summary of Contributions

### Code contributed

[[RepoSense Link]](https://nus-cs2113-ay2526-s2.github.io/tp-dashboard/?search=zhangyize2003&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2026-02-20T00%3A00%3A00&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&filteredFileName=)

### Enhancements implemented

**New feature:** Designed the core `Parser` class
- Implemented the initial `Parser` class with a switch-based command that reads user input and routes it to the appropriate `Command` subclass.
- Established the error handling pattern using `ExpensiveLehException`, which was adopted across all subsequent command parsing additions by the team.

**New feature:** Bookmark Feature

- Implemented `BookmarkCommand` to allow users to bookmark frequently used expenses from the expense list for quick re-entry.
- Implemented the `Bookmark` class in the `storage` package, which maintains an `ArrayList<Expense>` of bookmarked expenses and supports `save()` and `load()` operations for persistence to `data/bookmarks.txt`.
- Integrated bookmark support into `AddCommand` to allow users to add a bookmarked expense directly into the expense list via `add bookmark INDEX`.
- Integrated bookmark support into `DeleteCommand` to allow users to delete a bookmarked expense via `delete bookmark INDEX`.
- Integrated bookmark support into `ListCommand` to allow users to view all bookmarked expenses via `list bookmarks`.
- Integrating bookmark class to existing commands requires careful coordination across multiple existing classes without breaking their existing functionality.
- Improved `Bookmark.load()` to handle corrupted data gracefully by skipping invalid entries and display a warning instead of crashing or silently ignoring errors.

**Enhancements to existing features:** Remaining budget display after expense logging 
- After every successful expense addition via `add`, the remaining budget is immediately shown in the confirmation message.

**Enhancements to existing features:** `addCommand` handles spaces properly in expense names
- The parser correctly captures multi-word name for expenses.

**Enhancements to existing features:** Input validation across `add`, `edit` and `budget` commands
- Added character validation for expense names, rejecting inputs that contain characters which could corrupt the save file or cause parsing errors, while still allowing commonly used characters such as apostrophes, hyphens, and brackets.
- This required analysing the save format to identify that having "|" delimiters in names would break the parser on reload, then determining the minimal set of characters to block without being unnecessarily restrictive to users.
- Added an upper bound of 1,000,000,000 for all amount and budget fields across add, edit, and budget commands to guard against unrealistic or buggy inputs.

**Enhancements to existing features:** Stricter date parsing
- Updated date parsing in both `parseAddCommand()` and `parseEditCommand()` to reject dates that are syntactically valid but do not exist on the calendar (e.g. 30-02-2026). 
- Improved the `DateTimeParseException` error message to clearly inform the user that the date does not exist, rather than showing a generic format error.

### Contributions to the User Guide

- Documented the bookmark feature including:
  - Bookmarking an expense (`bookmark INDEX`)
  - Adding a bookmarked expense to the expense list (`add bookmark INDEX`)
  - Deleting a bookmark (`delete bookmark INDEX`)
  - Listing all bookmarks (`list bookmarks`)
- Documented the `add` command for adding expenses, loans, and bookmarks.
- Documented the `edit` command for editing expenses and loans.
- Documented the `delete` command for deleting expenses, loans, and bookmarks.
- Documented the `help` command for listing all the available commands in `ExpensiveLeh`

### Contributions to the Developer Guide

**Design Section:**

- Wrote the Parser component section, including:
  - Class diagram of the `Parser` class and all `Command` subclasses it instantiates (`ParserClassDiagram.png`)
  - Class diagram showing `Command` dependencies on `Managers`, `UI`, and `Expense` subclasses (`ParserDependenciesDiagram.png`)
  - Sequence diagram illustrating the full `readCommand()` flow across all supported  commands (`ReadCommandSequenceDiagram.png`)
  - Written explanation of how the `Parser` component works and how parsing works

**Implementation Section:**

- Wrote the Bookmark Feature section, including:
  - Class diagram of the `Bookmark` and `BookmarkCommand` classes (`BookmarkClassDiagram.png`)
  - Sequence diagram illustrating the `bookmark 2` command execution flow (`BookmarkSequenceDiagram.png`)
  - Step-by-step usage scenario for `BookmarkCommand`
  - Design considerations for how bookmarks are persisted and stored, with two alternatives evaluated for each aspect

### Contributions to team-based tasks

- Wrote JUnit tests for the `Bookmark` and `BookmarkCommand` classes in `BookmarkTest.java`.
- Wrote JUnit tests for the `Parser` class in `ParserTest.java`.
- Helped to coordinate task assignment among team members.
- Standardised the formatting and structure of the entire User Guide for consistency across all sections (PR #[60](https://github.com/AY2526S2-CS2113-W11-3/tp/pull/60)).
- Released v2.0 on GitHub.

### Review/mentoring contributions

- Frequently reviewed team pull requests.
- Reported functional and documentation bugs in the system (Issue #[71](https://github.com/AY2526S2-CS2113-W11-3/tp/issues/71), Issue #[107](https://github.com/AY2526S2-CS2113-W11-3/tp/issues/107)).