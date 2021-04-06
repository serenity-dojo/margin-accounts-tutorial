Feature: Margin Trading

  As an investor
  I want to be able to leverage my cash assets  take larger positions
  So that I can increase my gains

  Margin trading is the act of borrowing funds from a broker with the aim of investing in financial securities.
  The purchased stock serves as collateral for the loan. The primary reason behind borrowing money is to utilize more
  capital to invest and, by extension, the potential for more profits.

  Rule: An investor can borrow up to 50% of the total price on margin for shares
  This is referred to as the Initial Margin

    Background:
      Given Ian has a margin account with $50000 in cash
      And Facebook is trading at a market price of $100

    Example: An investor buys some shares on margin
      When he makes the following transaction:
        | Security | Buy/Sell | Number of shares | Cash   | Margin Loan |
        | Facebook | BUY      | 1000             | $50000 | $50000      |
      Then he should have the following position:
        | Security | Buy/Sell | Number of shares | Initial Price | Cash   | Margin Loan | Value   | Initial Margin |
        | Facebook | BUY      | 1000             | $100          | $50000 | $50000      | $100000 | 50%            |

    Example: The maximum initial margin is 50%
      When he attempts to make the following transaction:
        | Security | Buy/Sell | Number of shares | Cash   | Margin Loan |
        | Facebook | BUY      | 1000             | $40000 | $60000      |
      Then the transaction should be rejected

  Rule: The equity of an account is the current market value of the securities and cash less what is owed to the broker
    Scenario Outline: Ian's initial equity position based on the % of the loan
      Given XYZ is trading at a market price of $50
      When he makes the following transaction:
        | Security | Buy/Sell | Number of shares | Cash   | Margin Loan   |
        | XYZ      | BUY      | 1000             | <Cash> | <Margin Loan> |
      Then his initial equity on this position is:
        | Security | Number of shares | Value   | Loan   | Equity   | % Equity    |
        | XYZ      | 1000             | <Value> | <Loan> | <Equity> | <% Equity>% |
      Examples:
        | Title             | Cash   | Margin Loan | Value  | Loan   | Equity | % Equity |
        | A 20% margin loan | $40000 | $10000      | $50000 | $10000 | $40000 | 80%      |
        | A 50% margin loan | $25000 | $25000      | $50000 | $25000 | $25000 | 50%      |

  Rule: The equity of an account is the current market value of the securities and cash less what is owed to the broker

    Scenario Outline: The % Equity varies as the market price changes
      Given Ian has the following initial position:
        | Security | Buy/Sell | Number of shares | Cash  | Margin Loan | Initial Market Price |
        | XYZ      | BUY      | 1000             | 40000 | 10000       | $50                  |
      When the current market price of XYZ is <Current Market Price>
      Then the equity on his position is:
        | Security | Number of shares | Value   | Equity   | % Equity    |
        | XYZ      | 1000             | <Value> | <Equity> | <% Equity>% |
      Examples:
        | Title                       | Current Market Price | Value  | Equity | % Equity |
        | Market price stays the same | $50                  | $50000 | $40000 | 80%      |
        | Market price goes up        | $60                  | $60000 | $50000 | 83%      |
        | Market price goes down      | $40                  | $40000 | $30000 | 75%      |

  Rule: Investors must keep a margin of at least 30% on their account
  This is known as "Margin Maintenance"
    Example: Ian gets a margin call when a share price drops too much
      Given Ian has the following initial position:
        | Security | Buy/Sell | Number of shares | Cash  | Margin Loan | Initial Market Price |
        | XYZ      | BUY      | 1000             | 25000 | 25000       | $50                  |
      When the current market price of XYZ drops to $35
      Then the equity on his position is:
        | Security | Number of shares | Value  | Equity | % Equity |
        | XYZ      | 1000             | $35000 | $10000 | 28.5     |
      And he should get a margin call for $525


