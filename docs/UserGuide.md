# User Guide

## Introduction

{Give a product intro}

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 17 or above installed.
2. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features 

## Loans
ExpensiveLeh can keep track of people who owe you money.

### Adding a loan: `add`
Adds a new loan.

Format: `add c/loan n/NAME a/AMOUNT [date/DATE]`

Example of usage: 

`add c/loan n/Jack a/100`

Output:
````
ExpensiveLeh says -> Loan recorded successfully!
Debtor   : Jack
Amount   : $100.00
Date     : 30-03-2026
Total Owed to You: $2433.00
________________________________________________________________
````
### Listing a loan: `list`
Lists all loans.

Format: `list loans`

Output:
````
ExpensiveLeh says -> 
--- Current Loans (Money Owed to You) ---
1    [OWED BY] Kim | $2333.00 | 24-03-2026
2    [OWED BY] Jack | $100.00 | 30-03-2026

Total Owed to You: $2433.00
________________________________________________________________
````

### Deleting a loan: `delete`
Deletes the specified loan.
Format: `delete INDEX`
* Deletes the person at the specified `INDEX`. 
* The `INDEX` refers to the index number showed in the displayed loan list.
* The index must be a **positive intege**r 1,2,3 ...
### Managing budgets : `budget`

Sets a budget for overall spending or for a specific category.

Format: `budget AMOUNT` or `budget c/CATEGORY a/AMOUNT`

*   Sets the global budget to `AMOUNT` if no category is specified.
*   Sets a category-specific budget if `c/CATEGORY a/AMOUNT` format is used.
*   Budget amounts must be positive.

`delete loan 1`

Output:
`ExpensiveLeh says -> Loan ID 1 for Kim ($2333.00) deleted!`

## Saving Data
Loans, expenses, bookmarks and budgets are automatically saved in the disk. There is no need to save manually. 

Examples:

*   `budget 1000`
    ```
    ________________________________________________________________________________
    ExpensiveLeh says -> Budget of $1000.00 set successfully!
    ________________________________________________________________________________
    ```
    Sets the overall budget to $1000.

*   `budget c/Food a/500`
    ```
    ________________________________________________________________________________
    ExpensiveLeh says -> Budget of $500.00 set successfully for Food!
    ________________________________________________________________________________
    ```
    Sets the food category budget to $500.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: {your answer here}

## Command Summary

{Give a 'cheat sheet' of commands here}

* Add todo `todo n/TODO_NAME d/DEADLINE`
