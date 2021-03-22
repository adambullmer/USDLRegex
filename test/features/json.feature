Feature: Valid Regex Rules
    In order to ensure our validators have not changed
    As a developer
    I want a high level of confidence when I make a change to a validator
    The resulting validation rule is equivelant

    Scenario Outline: Regex Validation
        Given I have the state <state>
        And I have a drivers license <license>
        When I validate the license
        Then the result is <result>

        Examples:
            | state | license              | result |
            | AL    | 1                    | TRUE   |
            | AL    | 12                   | TRUE   |
            | AL    | 123                  | TRUE   |
            | AL    | 1234                 | TRUE   |
            | AL    | 12345                | TRUE   |
            | AL    | 123456               | TRUE   |
            | AL    | 1234567              | TRUE   |
            | AL    | 12345678             | TRUE   |
            | AL    | 123456789            | FALSE  |
            | AL    | 123456A              | FALSE  |

            | AK    | 1                    | TRUE   |
            | AK    | 12                   | TRUE   |
            | AK    | 123                  | TRUE   |
            | AK    | 1234                 | TRUE   |
            | AK    | 12345                | TRUE   |
            | AK    | 123456               | TRUE   |
            | AK    | 1234567              | TRUE   |
            | AK    | 12345678             | FALSE  |
            | AK    | 123456A              | FALSE  |

            | AZ    | A12345678            | TRUE   |
            | AZ    | A123456789           | FALSE  |
            | AZ    | AB12345678           | FALSE  |
            | AZ    | AB12345              | TRUE   |
            | AZ    | ABC12345             | FALSE  |
            | AZ    | AB123456             | FALSE  |
            | AZ    | 123456789            | TRUE   |
            | AZ    | 12345678             | FALSE  |
            | AZ    | 1234567890           | FALSE  |

            | AR    | 1234                 | TRUE   |
            | AR    | 12345                | TRUE   |
            | AR    | 123456               | TRUE   |
            | AR    | 1234567              | TRUE   |
            | AR    | 12345678             | TRUE   |
            | AR    | 123456789            | TRUE   |
            | AR    | 1234567890           | FALSE  |
            | AR    | 12345678A            | FALSE  |

            | CA    | A1234567             | TRUE   |
            | CA    | AB1234567            | FALSE  |
            | CA    | A12345678            | FALSE  |
            | CA    | A123456              | FALSE  |
            | CA    | 12345678             | FALSE  |

            | CO    | 123456789            | TRUE   |
            | CO    | 12345678             | FALSE  |
            | CO    | 1234567890           | FALSE  |
            | CO    | A123                 | TRUE   |
            | CO    | A1234                | TRUE   |
            | CO    | A12345               | TRUE   |
            | CO    | A123456              | TRUE   |
            | CO    | A1234567             | FALSE  |
            | CO    | AB123456             | FALSE  |
            | CO    | AB12                 | TRUE   |
            | CO    | AB123                | TRUE   |
            | CO    | AB1234               | TRUE   |
            | CO    | AB12345              | TRUE   |
            | CO    | AB123456             | FALSE  |
            | CO    | ABC1                 | FALSE  |

            | CT    | 123456789            | TRUE   |
            | CT    | 12345678             | FALSE  |
            | CT    | 1234567890           | FALSE  |
            | CT    | A12345678            | FALSE  |

            | DE    | 1                    | TRUE   |
            | DE    | 12                   | TRUE   |
            | DE    | 123                  | TRUE   |
            | DE    | 1234                 | TRUE   |
            | DE    | 12345                | TRUE   |
            | DE    | 123456               | TRUE   |
            | DE    | 1234567              | TRUE   |
            | DE    | 12345678             | FALSE  |
            | DE    | A234567              | FALSE  |
            | DE    | 123456A              | FALSE  |

            | DC    | 1234567              | TRUE   |
            | DC    | 123456789            | TRUE   |
            | DC    | 12345678             | FALSE  |
            | DC    | A234567              | FALSE  |
            | DC    | A23456789            | FALSE  |

            | FL    | A123456789012        | TRUE   |
            | FL    | AB12345678901        | FALSE  |
            | FL    | A12345678901         | FALSE  |
            | FL    | A1234567890123       | FALSE  |

            | GA    | 1234567              | TRUE   |
            | GA    | 12345678             | TRUE   |
            | GA    | 123456789            | TRUE   |
            | GA    | 123456               | FALSE  |
            | GA    | 1234567890           | FALSE  |
            | GA    | A12345678            | FALSE  |

            | GU    | A12345678901234      | TRUE   |
            | GU    | AB12345678901234     | FALSE  |
            | GU    | 12345678901234       | FALSE  |
            | GU    | 12345678901234A      | FALSE  |
            | GU    | A1234567890123       | FALSE  |
            | GU    | A123456789012345     | FALSE  |

            | HI    | A12345678            | TRUE   |
            | HI    | A123456789           | FALSE  |
            | HI    | A1234567             | FALSE  |
            | HI    | AB1234567            | FALSE  |
            | HI    | 123456789            | TRUE   |
            | HI    | 12345678             | FALSE  |
            | HI    | 1234567890           | FALSE  |
            | HI    | 12345678A            | FALSE  |

            | ID    | AB123456A            | TRUE   |
            | ID    | ABC12345A            | FALSE  |
            | ID    | A1234567A            | FALSE  |
            | ID    | A123456AB            | FALSE  |
            | ID    | 123456789            | TRUE   |
            | ID    | 12345678             | FALSE  |
            | ID    | 1234567890           | FALSE  |
            | ID    | A12345678            | FALSE  |
            | ID    | 12345678A            | FALSE  |

            | IL    | A12345678901         | TRUE   |
            | IL    | A123456789012        | TRUE   |
            | IL    | A1234567890          | FALSE  |
            | IL    | A1234567890123       | FALSE  |
            | IL    | AB123456789012       | FALSE  |
            | IL    | 123456789012A        | FALSE  |

            | IN    | A123456789           | TRUE   |
            | IN    | AB123456789          | FALSE  |
            | IN    | A1234567890          | FALSE  |
            | IN    | 123456789            | TRUE   |
            | IN    | 1234567890           | TRUE   |
            | IN    | 12345678             | FALSE  |
            | IN    | 12345678901          | FALSE  |

            | IA    | 123456789            | TRUE   |
            | IA    | 12345678             | FALSE  |
            | IA    | 1234567890           | FALSE  |
            | IA    | A123456789           | FALSE  |
            | IA    | 123456789A           | FALSE  |
            | IA    | 123AB1234            | TRUE   |
            | IA    | 1234AB123            | FALSE  |
            | IA    | 123ABC1234           | FALSE  |
            | IA    | 12AB1234             | FALSE  |
            | IA    | 123AB123             | FALSE  |
            | IA    | 1234AB1234           | FALSE  |
            | IA    | 123AB12345           | FALSE  |

            | KS    | A1A1A                | TRUE   |
            | KS    | AB1A1A               | FALSE  |
            | KS    | A1AB1A               | FALSE  |
            | KS    | A1A1AB               | FALSE  |
            | KS    | A12A1A               | FALSE  |
            | KS    | A1A12A               | FALSE  |
            | KS    | A1A1A1               | FALSE  |
            | KS    | ABC12                | FALSE  |
            | KS    | 12ABC                | FALSE  |
            | KS    | A12345678            | TRUE   |
            | KS    | A123456789           | FALSE  |
            | KS    | A1234567             | FALSE  |
            | KS    | AB12345678           | FALSE  |
            | KS    | 123456789            | TRUE   |
            | KS    | 12345678             | FALSE  |
            | KS    | 1234567890           | FALSE  |
            | KS    | 123456789A           | FALSE  |

            | KY    | A12345678            | TRUE   |
            | KY    | A123456789           | TRUE   |
            | KY    | A1234567             | FALSE  |
            | KY    | A1234567890          | FALSE  |
            | KY    | AB12345678           | FALSE  |
            | KY    | 123456789            | TRUE   |
            | KY    | 12345678             | FALSE  |
            | KY    | 1234567890           | FALSE  |
            | KY    | 123456789A           | FALSE  |
            | KY    | 12345678A            | FALSE  |

            | LA    | 1                    | TRUE   |
            | LA    | 12                   | TRUE   |
            | LA    | 123                  | TRUE   |
            | LA    | 1234                 | TRUE   |
            | LA    | 12345                | TRUE   |
            | LA    | 123456               | TRUE   |
            | LA    | 1234567              | TRUE   |
            | LA    | 12345678             | TRUE   |
            | LA    | 123456789            | TRUE   |
            | LA    | 1234567890           | FALSE  |
            | LA    | 123456789A           | FALSE  |
            | LA    | A123456789           | FALSE  |
            | LA    | A12345678            | FALSE  |

            | ME    | 1234567              | TRUE   |
            | ME    | 12345678             | TRUE   |
            | ME    | 123456789            | FALSE  |
            | ME    | 123456               | FALSE  |
            | ME    | A1234567             | FALSE  |
            | ME    | A12345678            | FALSE  |
            | ME    | 1234567A             | TRUE   |
            | ME    | 1234567AB            | FALSE  |
            | ME    | 12345678A            | FALSE  |
            | ME    | 1234567AB            | FALSE  |
            | ME    | A1234567A            | FALSE  |

            | MD    | A123456789012        | TRUE   |
            | MD    | A12345678901         | FALSE  |
            | MD    | A1234567890123       | FALSE  |
            | MD    | AB123456789012       | FALSE  |
            | MD    | 123456789012A        | FALSE  |

            | MA    | A12345678            | TRUE   |
            | MA    | AB12345678           | FALSE  |
            | MA    | AB1234567            | TRUE   |
            | MA    | A123456789           | FALSE  |
            | MA    | A1234567             | FALSE  |
            | MA    | 123456789            | TRUE   |
            | MA    | 12345678             | FALSE  |
            | MA    | 1234567890           | FALSE  |
            | MA    | 12345678A            | FALSE  |

            | MI    | A1234567890          | TRUE   |
            | MI    | A123456789012        | TRUE   |
            | MI    | A123456789           | FALSE  |
            | MI    | A12345678901         | FALSE  |
            | MI    | A1234567890123       | FALSE  |
            | MI    | AB1234567890         | FALSE  |
            | MI    | AB123456789012       | FALSE  |
            | MI    | 1234567890A          | FALSE  |
            | MI    | 123456789012A        | FALSE  |

            | MN    | A123456789012        | TRUE   |
            | MN    | A12345678901         | FALSE  |
            | MI    | A1234567890123       | FALSE  |
            | MN    | AB123456789012       | FALSE  |
            | MN    | 123456789012A        | FALSE  |

            | MS    | 123456789            | TRUE   |
            | MS    | 12345678             | FALSE  |
            | MS    | 1234567890           | FALSE  |
            | MS    | A123456789           | FALSE  |
            | MS    | 123456789A           | FALSE  |
            | MS    | A12345678            | FALSE  |
            | MS    | 12345678A            | FALSE  |

            | MO    | A12345               | TRUE   |
            | MO    | A123456              | TRUE   |
            | MO    | A1234567             | TRUE   |
            | MO    | A12345678            | TRUE   |
            | MO    | A123456789           | TRUE   |
            | MO    | A1234567890          | FALSE  |
            | MO    | AB123456789          | FALSE  |
            | MO    | A123456R             | TRUE   |
            | MO    | A123456A             | FALSE  |
            | MO    | A1234567R            | FALSE  |
            | MO    | A12345R              | FALSE  |
            | MO    | AB123456R            | FALSE  |
            | MO    | AB123456R            | FALSE  |
            | MO    | 12345678AB           | TRUE   |
            | MO    | 12345678ABC          | FALSE  |
            | MO    | 1234567AB            | FALSE  |
            | MO    | 123456789A           | TRUE   |
            | MO    | 12345678A            | FALSE  |
            | MO    | 1234567890A          | FALSE  |
            | MO    | 123456789AB          | FALSE  |
            | MO    | 12345678ABC          | FALSE  |
            | MO    | 123456789            | TRUE   |
            | MO    | 12345678             | FALSE  |
            | MO    | 1234567890           | FALSE  |
            | MO    | 123A123456           | TRUE   |
            | MO    | 123AB23456           | FALSE  |
            | MO    | 12A123456            | FALSE  |
            | MO    | 123A1234567          | FALSE  |

            | MT    | A12345678            | TRUE   |
            | MT    | A1234567             | FALSE  |
            | MT    | A123456789           | FALSE  |
            | MT    | AB12345678           | FALSE  |
            | MT    | 12345678A            | FALSE  |
            | MT    | AB12345678           | FALSE  |
            | MT    | 12345678             | FALSE  |
            | MT    | 123456789            | TRUE   |
            | MT    | 1234567890           | FALSE  |
            | MT    | 12345678901          | FALSE  |
            | MT    | 123456789012         | FALSE  |
            | MT    | 1234567890123        | TRUE   |
            | MT    | 12345678901234       | TRUE   |
            | MT    | 123456789012345      | FALSE  |
            | MT    | A123456789           | FALSE  |
            | MT    | 123456789A           | FALSE  |
            | MT    | A1234567890123       | FALSE  |
            | MT    | 1234567890123A       | FALSE  |
            | MT    | A123456789012        | FALSE  |
            | MT    | 123456789012A        | FALSE  |
            | MT    | A12345678901234      | FALSE  |
            | MT    | 12345678901234A      | FALSE  |

            | NE    | 1                    | TRUE   |
            | NE    | 12                   | TRUE   |
            | NE    | 123                  | TRUE   |
            | NE    | 1234                 | TRUE   |
            | NE    | 12345                | TRUE   |
            | NE    | 123456               | TRUE   |
            | NE    | 1234567              | TRUE   |
            | NE    | 12345678             | FALSE  |
            | NE    | A1234567             | TRUE   |
            | NE    | A12345678            | TRUE   |
            | NE    | A123456789           | FALSE  |
            | NE    | 1234567A             | FALSE  |

            | NV    | 123456789            | TRUE   |
            | NV    | 12345678             | FALSE  |
            | NV    | 1234567890           | TRUE   |
            | NV    | 12345678901          | FALSE  |
            | NV    | 123456789012         | TRUE   |
            | NV    | X12345678            | TRUE   |
            | NV    | X1234567             | FALSE  |
            | NV    | A12345678            | FALSE  |
            | NV    | XX12345678           | FALSE  |
            | NV    | 12345678X            | FALSE  |
            | NV    | X123456789           | FALSE  |
            | NV    | X1234567890          | FALSE  |
            | NV    | X123456789012        | FALSE  |
            | NV    | 12345678A            | FALSE  |

            | NH    | 12ABC12345           | TRUE   |
            | NH    | 123ABC1234           | FALSE  |
            | NH    | 12345ABC12           | FALSE  |
            | NH    | 12AB12345            | FALSE  |
            | NH    | 12ABCD12345          | FALSE  |
            | NH    | 12AB12345            | FALSE  |
            | NH    | 12ABC1234            | FALSE  |
            | NH    | 12ABC123456          | FALSE  |

            | NJ    | A12345678901234      | TRUE   |
            | NJ    | A123456789012345     | FALSE  |
            | NJ    | A1234567890123       | FALSE  |
            | NJ    | AB12345678901234     | FALSE  |
            | NJ    | 123456789012345      | FALSE  |
            | NJ    | 12345678901234       | FALSE  |

            | NM    | 12345678             | TRUE   |
            | NM    | 123456789            | TRUE   |
            | NM    | 1234567              | FALSE  |
            | NM    | 1234567890           | FALSE  |
            | NM    | A12345678            | FALSE  |
            | NM    | A123456789           | FALSE  |
            | NM    | 12345678A            | FALSE  |
            | NM    | 123456789A           | FALSE  |

            | NY    | A1234567             | TRUE   |
            | NY    | A123456              | FALSE  |
            | NY    | A12345678            | FALSE  |
            | NY    | AB123456             | FALSE  |
            | NY    | 1234567A             | FALSE  |
            | NY    | A123456789012345678  | TRUE   |
            | NY    | A12345678901234567   | FALSE  |
            | NY    | A1234567890123456789 | FALSE  |
            | NY    | AB123456789012345678 | FALSE  |
            | NY    | 123456789012345678A  | FALSE  |
            | NY    | 12345678             | TRUE   |
            | NY    | 123456789            | TRUE   |
            | NY    | 1234567              | FALSE  |
            | NY    | 1234567890           | FALSE  |
            | NY    | 1234567A             | FALSE  |
            | NY    | A12345678            | FALSE  |
            | NY    | 12345678A            | FALSE  |
            | NY    | A123456789           | FALSE  |
            | NY    | 123456789A           | FALSE  |
            | NY    | 1234567890123456     | TRUE   |
            | NY    | 123456789012345      | FALSE  |
            | NY    | 12345678901234567    | FALSE  |
            | NY    | A123456789012345     | FALSE  |
            | NY    | 123456789012345A     | FALSE  |
            | NY    | A1234567890123456    | FALSE  |
            | NY    | 1234567890123456A    | FALSE  |

            | NC    | 1                    | TRUE   |
            | NC    | 12                   | TRUE   |
            | NC    | 123                  | TRUE   |
            | NC    | 1234                 | TRUE   |
            | NC    | 12345                | TRUE   |
            | NC    | 123456               | TRUE   |
            | NC    | 1234567              | TRUE   |
            | NC    | 12345678             | TRUE   |
            | NC    | 123456789            | TRUE   |
            | NC    | 1234567890           | TRUE   |
            | NC    | 12345678901          | TRUE   |
            | NC    | 123456789012         | TRUE   |
            | NC    | 1234567890123        | FALSE  |
            | NC    | A123456789012        | FALSE  |
            | NC    | 123456789012A        | FALSE  |
            | NC    | A12345678901         | FALSE  |
            | NC    | 12345678901A         | FALSE  |

            | ND    | ABC123456            | TRUE   |
            | ND    | ABC12345             | FALSE  |
            | ND    | ABC1234567           | FALSE  |
            | ND    | AB123456             | FALSE  |
            | ND    | ABCD123456           | FALSE  |
            | ND    | 123456789            | TRUE   |
            | ND    | 12345678             | FALSE  |
            | ND    | 1234567890           | FALSE  |
            | ND    | A123456789           | FALSE  |
            | ND    | 123456789A           | FALSE  |
            | ND    | A12345678            | FALSE  |
            | ND    | 12345678A            | FALSE  |

            | OH    | A1234                | TRUE   |
            | OH    | A12345               | TRUE   |
            | OH    | A123456              | TRUE   |
            | OH    | A1234567             | TRUE   |
            | OH    | A12345678            | TRUE   |
            | OH    | A123                 | FALSE  |
            | OH    | A123456789           | FALSE  |
            | OH    | 12345678A            | FALSE  |
            | OH    | 1234567A             | FALSE  |
            | OH    | AB123                | TRUE   |
            | OH    | AB1234               | TRUE   |
            | OH    | AB12345              | TRUE   |
            | OH    | AB123456             | TRUE   |
            | OH    | AB1234567            | TRUE   |
            | OH    | AB12345678           | FALSE  |
            | OH    | ABC123               | FALSE  |
            | OH    | ABC12                | FALSE  |
            | OH    | 12345678AB           | FALSE  |
            | OH    | 123AB                | FALSE  |
            | OH    | 12345678             | TRUE   |
            | OH    | 1234567              | FALSE  |
            | OH    | 123456789            | FALSE  |

            | OK    | A123456789           | TRUE   |
            | OK    | A12345678            | FALSE  |
            | OK    | A1234567890          | FALSE  |
            | OK    | 123456789A           | FALSE  |
            | OK    | AB123456789          | FALSE  |
            | OK    | 123456789            | TRUE   |

            | OR    | 1                    | TRUE   |
            | OR    | 12                   | TRUE   |
            | OR    | 123                  | TRUE   |
            | OR    | 1234                 | TRUE   |
            | OR    | 12345                | TRUE   |
            | OR    | 123456               | TRUE   |
            | OR    | 1234567              | TRUE   |
            | OR    | 12345678             | TRUE   |
            | OR    | 123456789            | TRUE   |
            | OR    | 1234567890           | FALSE  |
            | OR    | A123456789           | FALSE  |
            | OR    | 123456789A           | FALSE  |
            | OR    | A1234567             | TRUE   |
            | OR    | A12345678            | FALSE  |
            | OR    | 12345678A            | FALSE  |
            | OR    | A123456              | TRUE   |
            | OR    | AA123456             | FALSE  |
            | OR    | B123456              | TRUE   |
            | OR    | C12345               | FALSE  |
            | OR    | C123456              | TRUE   |
            | OR    | C1234567             | TRUE   |
            | OR    | A12345               | FALSE  |
            | OR    | B1234567             | TRUE   |
            | OR    | B12345678            | FALSE  |

            | PA    | 12345678             | TRUE   |
            | PA    | 1234567              | FALSE  |
            | PA    | 123456789            | FALSE  |
            | PA    | A12345678            | FALSE  |
            | PA    | 12345678A            | FALSE  |
            | PA    | A1234567             | FALSE  |
            | PA    | 1234567A             | FALSE  |

            | PR    | 12345                | TRUE   |
            | PR    | 123456               | TRUE   |
            | PR    | 1234567              | TRUE   |
            | PR    | 12345678             | FALSE  |
            | PR    | 123456789            | TRUE   |
            | PR    | 1234567890           | FALSE  |
            | PR    | 1234                 | FALSE  |
            | PR    | A12345               | FALSE  |
            | PR    | 12345A               | FALSE  |
            | PR    | A123456789           | FALSE  |
            | PR    | 123456789A           | FALSE  |

            | RI    | 1234567              | TRUE   |
            | RI    | 123456               | FALSE  |
            | RI    | 12345678             | TRUE   |
            | RI    | 123456789            | FALSE  |
            | RI    | A1234567             | FALSE  |
            | RI    | 1234567A             | FALSE  |
            | RI    | A123456              | TRUE   |
            | RI    | A12345               | FALSE  |
            | RI    | 12345A               | FALSE  |
            | RI    | 123456A              | FALSE  |
            | RI    | AB123456             | FALSE  |

            | SC    | 12345                | TRUE   |
            | SC    | 123456               | TRUE   |
            | SC    | 1234567              | TRUE   |
            | SC    | 12345678             | TRUE   |
            | SC    | 123456789            | TRUE   |
            | SC    | 1234567890           | TRUE   |
            | SC    | 12345678901          | TRUE   |
            | SC    | 123456789012         | FALSE  |
            | SC    | 1234                 | FALSE  |
            | SC    | A12345678901         | FALSE  |
            | SC    | 12345678901A         | FALSE  |
            | SC    | A12345               | FALSE  |
            | SC    | 12345A               | FALSE  |
            | SC    | A1234567890          | FALSE  |
            | SC    | 1234567890A          | FALSE  |

            | SD    | 123456               | TRUE   |
            | SD    | 1234567              | TRUE   |
            | SD    | 12345678             | TRUE   |
            | SD    | 123456789            | TRUE   |
            | SD    | 1234567890           | TRUE   |
            | SD    | 12345678901          | FALSE  |
            | SD    | 123456789012         | TRUE   |
            | SD    | 1234567890123        | FALSE  |
            | SD    | 12345                | FALSE  |
            | SD    | A12345               | FALSE  |
            | SD    | 12345A               | FALSE  |
            | SD    | A12345677890         | FALSE  |
            | SD    | 12345677890A         | FALSE  |
            | SD    | A1234567789012       | FALSE  |
            | SD    | 1234567789012A       | FALSE  |
            | SD    | 1234567789A          | FALSE  |
            | SD    | A1234567789          | FALSE  |

            | TN    | 1234567              | TRUE   |
            | TN    | 12345678             | TRUE   |
            | TN    | 123456789            | TRUE   |
            | TN    | 1234567890           | FALSE  |
            | TN    | 123456               | FALSE  |
            | TN    | A1234567             | FALSE  |
            | TN    | 1234567A             | FALSE  |

            | TX    | 1234567              | TRUE   |
            | TX    | 12345678             | TRUE   |
            | TX    | 123456789            | FALSE  |
            | TX    | 123456               | FALSE  |
            | TX    | A1234567             | FALSE  |
            | TX    | 1234567A             | FALSE  |

            | UT    | 1234                 | TRUE   |
            | UT    | 12345                | TRUE   |
            | UT    | 123456               | TRUE   |
            | UT    | 1234567              | TRUE   |
            | UT    | 12345678             | TRUE   |
            | UT    | 123456789            | TRUE   |
            | UT    | 1234567890           | TRUE   |
            | UT    | 12345678901          | FALSE  |
            | UT    | 123                  | FALSE  |
            | UT    | A1234567890          | FALSE  |
            | UT    | 1234567890A          | FALSE  |

            | VT    | 12345678             | TRUE   |
            | VT    | A12345678            | FALSE  |
            | VT    | 12345678A            | FALSE  |
            | VT    | 1234567A             | TRUE   |
            | VT    | 1234567B             | FALSE  |
            | VT    | 123456A              | FALSE  |

            | VA    | A123456789           | TRUE   |
            | VA    | A1234567890          | TRUE   |
            | VA    | A12345678901         | TRUE   |
            | VA    | A12345678            | TRUE   |
            | VA    | A123456789012        | FALSE  |
            | VA    | 123456789A           | FALSE  |
            | VA    | AB123456789          | FALSE  |
            | VA    | 123456789A           | FALSE  |
            | VA    | 123456789            | TRUE   |
            | VA    | 12345678             | FALSE  |
            | VA    | 1234567890           | FALSE  |

            | WA    | A12345678901         | TRUE   |
            | WA    | AABCDEFGHIJK         | TRUE   |
            | WA    | ABCDEFGABCDE         | TRUE   |
            | WA    | ABCDEFG12345         | TRUE   |
            | WA    | ABCDEFG*****         | TRUE   |
            | WA    | A***********         | TRUE   |
            | WA    | A1*A1*A1*A1*         | TRUE   |
            | WA    | A1**********         | TRUE   |
            | WA    | AB1*********         | TRUE   |
            | WA    | ABC1********         | TRUE   |
            | WA    | ABCD1*******         | TRUE   |
            | WA    | ABCDE1******         | TRUE   |
            | WA    | ABCDEF1*****         | TRUE   |
            | WA    | A-**********         | FALSE  |
            | WA    | 123456789012         | FALSE  |
            | WA    | ************         | FALSE  |
            | WA    | ABCDEFG12345678901   | FALSE  |

            | WV    | 1234567              | TRUE   |
            | WV    | 123456               | FALSE  |
            | WV    | 12345678             | FALSE  |
            | WV    | A12345               | TRUE   |
            | WV    | A123456              | TRUE   |
            | WV    | AB12345              | TRUE   |
            | WV    | AB123456             | TRUE   |
            | WV    | ABC12345             | FALSE  |
            | WV    | A1234567             | FALSE  |
            | WV    | 12345A               | FALSE  |
            | WV    | 12345AB              | FALSE  |

            | WI    | A1234567890123       | TRUE   |
            | WI    | A123456789012        | FALSE  |
            | WI    | A12345678901234      | FALSE  |
            | WI    | 1234567890123        | FALSE  |
            | WI    | 1234567890123A       | FALSE  |
            | WI    | AB1234567890123      | FALSE  |
            | WI    | AB123456789012       | FALSE  |

            | WY    | 123456789            | TRUE   |
            | WY    | 1234567890           | TRUE   |
            | WY    | 12345678             | FALSE  |
            | WY    | 12345678901          | FALSE  |
            | WY    | A123456789           | FALSE  |
            | WY    | 123456789A           | FALSE  |
            | WY    | A1234567890          | FALSE  |
            | WY    | 1234567890A          | FALSE  |
