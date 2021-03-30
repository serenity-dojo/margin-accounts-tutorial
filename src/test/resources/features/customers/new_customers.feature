Feature: New Customers

  Rule: New customers should be allocated a unique customer ID
    Example: Christine opens a new account
      Given Christine is
        | First name | Last name | Address          |
        | Christine  | Client    | 10 Client Street |
      When Christine opens a new account
