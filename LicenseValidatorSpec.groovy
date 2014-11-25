package validate.basic

import model.State
import spock.lang.Specification
import spock.lang.Unroll

class LicenseValidatorSpec extends Specification{
    @Unroll
    void "License number #number for #state is #validNotValid"(){
        expect:
        LicenseValidator.checkLicense(State.valueOfAbbreviation(state), number) == passed

        where:

        state   | number                | passed
        "AL"    | "123456"              | false
        "AL"    | "1234567"             | true
        "AL"    | "12345678"            | false
        "AL"    | "A123456"             | false
        "AL"    | "A1234567"            | false
        "AL"    | "ABCDEFG"             | false

        "AK"    | "123456"              | false
        "AK"    | "1234567"             | true
        "AK"    | "12345678"            | false
        "AK"    | "A123456"             | false
        "AK"    | "A1234567"            | false
        "AK"    | "ABCDEFG"             | false

        "ME"    | "123456"              | false
        "ME"    | "1234567"             | true
        "ME"    | "12345678"            | false
        "ME"    | "A123456"             | false
        "ME"    | "A1234567"            | false
        "ME"    | "ABCDEFG"             | false



        "AR"    | "12345678"            | false
        "AR"    | "123456789"           | true
        "AR"    | "1234567890"          | false
        "AR"    | "A12345678"           | false
        "AR"    | "A123456789"          | false
        "AR"    | "ABCDEFGHI"           | false

        "CO"    | "12345678"            | false
        "CO"    | "123456789"           | true
        "CO"    | "1234567890"          | false
        "CO"    | "A12345678"           | false
        "CO"    | "A123456789"          | false
        "CO"    | "ABCDEFGHI"           | false

        "CT"    | "12345678"            | false
        "CT"    | "123456789"           | true
        "CT"    | "1234567890"          | false
        "CT"    | "A12345678"           | false
        "CT"    | "A123456789"          | false
        "CT"    | "ABCDEFGHI"           | false

        "GA"    | "12345678"            | false
        "GA"    | "123456789"           | true
        "GA"    | "1234567890"          | false
        "GA"    | "A12345678"           | false
        "GA"    | "A123456789"          | false
        "GA"    | "ABCDEFGHI"           | false

        "IA"    | "12345678"            | false
        "IA"    | "123456789"           | true
        "IA"    | "1234567890"          | false
        "IA"    | "A12345678"           | false
        "IA"    | "A123456789"          | false
        "IA"    | "ABCDEFGHI"           | false

        "MS"    | "12345678"            | false
        "MS"    | "123456789"           | true
        "MS"    | "1234567890"          | false
        "MS"    | "A12345678"           | false
        "MS"    | "A123456789"          | false
        "MS"    | "ABCDEFGHI"           | false

        "NM"    | "12345678"            | false
        "NM"    | "123456789"           | true
        "NM"    | "1234567890"          | false
        "NM"    | "A12345678"           | false
        "NM"    | "A123456789"          | false
        "NM"    | "ABCDEFGHI"           | false

        "NY"    | "12345678"            | false
        "NY"    | "123456789"           | true
        "NY"    | "1234567890"          | false
        "NY"    | "A12345678"           | false
        "NY"    | "A123456789"          | false
        "NY"    | "ABCDEFGHI"           | false



        "AZ"    | "12345678"            | false
        "AZ"    | "123456789"           | true
        "AZ"    | "1234567890"          | false
        "AZ"    | "A1234567"            | false
        "AZ"    | "A12345678"           | true
        "AZ"    | "A123456789"          | false
        "AZ"    | "AB1234567"           | false
        "AZ"    | "AB12345678"          | false
        "AZ"    | "AB123456789"         | false
        "AZ"    | "ABCDEFGHI"           | false

        "HI"    | "12345678"            | false
        "HI"    | "123456789"           | true
        "HI"    | "1234567890"          | false
        "HI"    | "A1234567"            | false
        "HI"    | "A12345678"           | true
        "HI"    | "A123456789"          | false
        "HI"    | "AB1234567"           | false
        "HI"    | "AB12345678"          | false
        "HI"    | "AB123456789"         | false
        "HI"    | "ABCDEFGHI"           | false

        "KY"    | "12345678"            | false
        "KY"    | "123456789"           | true
        "KY"    | "1234567890"          | false
        "KY"    | "A1234567"            | false
        "KY"    | "A12345678"           | true
        "KY"    | "A123456789"          | false
        "KY"    | "AB1234567"           | false
        "KY"    | "AB12345678"          | false
        "KY"    | "AB123456789"         | false
        "KY"    | "ABCDEFGHI"           | false

        "VA"    | "12345678"            | false
        "VA"    | "123456789"           | true
        "VA"    | "1234567890"          | false
        "VA"    | "A1234567"            | false
        "VA"    | "A12345678"           | true
        "VA"    | "A123456789"          | false
        "VA"    | "AB1234567"           | false
        "VA"    | "AB12345678"          | false
        "VA"    | "AB123456789"         | false
        "VA"    | "ABCDEFGHI"           | false



        "IN"    | "123456789"           | false
        "IN"    | "1234567890"          | true
        "IN"    | "12345678901"         | false
        "IN"    | "A123456789"          | false
        "IN"    | "A1234567890"         | false
        "IN"    | "ABCDEFGHIJ"          | false

        "NV"    | "123456789"           | false
        "NV"    | "1234567890"          | true
        "NV"    | "12345678901"         | false
        "NV"    | "A123456789"          | false
        "NV"    | "A1234567890"         | false
        "NV"    | "ABCDEFGHIJ"          | false



        "FL"    | "123456789012"        | false
        "FL"    | "1234567890123"       | false
        "FL"    | "A12345678901"        | false
        "FL"    | "A123456789012"       | true
        "FL"    | "A1234567890123"      | false
        "FL"    | "AB12345678901"       | false
        "FL"    | "AB123456789012"      | false
        "FL"    | "ABCDEFGHIJKLM"       | false

        "MD"    | "123456789012"        | false
        "MD"    | "1234567890123"       | false
        "MD"    | "A12345678901"        | false
        "MD"    | "A123456789012"       | true
        "MD"    | "A1234567890123"      | false
        "MD"    | "AB12345678901"       | false
        "MD"    | "AB123456789012"      | false
        "MD"    | "ABCDEFGHIJKLM"       | false

        "MI"    | "123456789012"        | false
        "MI"    | "1234567890123"       | false
        "MI"    | "A12345678901"        | false
        "MI"    | "A123456789012"       | true
        "MI"    | "A1234567890123"      | false
        "MI"    | "AB12345678901"       | false
        "MI"    | "AB123456789012"      | false
        "MI"    | "ABCDEFGHIJKLM"       | false

        "MN"    | "123456789012"        | false
        "MN"    | "1234567890123"       | false
        "MN"    | "A12345678901"        | false
        "MN"    | "A123456789012"       | true
        "MN"    | "A1234567890123"      | false
        "MN"    | "AB12345678901"       | false
        "MN"    | "AB123456789012"      | false
        "MN"    | "ABCDEFGHIJKLM"       | false



        "OR"    | "123456"        | false
        "OR"    | "1234567"       | true
        "OR"    | "12345678"      | false
        "OR"    | "A12345"        | false
        "OR"    | "A123456"       | true
        "OR"    | "A1234567"      | false
        "OR"    | "AB12345"       | false
        "OR"    | "AB123456"      | false
        "OR"    | "AB1234567"     | false
        "OR"    | "ABCDEFG"       | false

        "RI"    | "123456"        | false
        "RI"    | "1234567"       | true
        "RI"    | "12345678"      | false
        "RI"    | "A12345"        | false
        "RI"    | "A123456"       | true
        "RI"    | "A1234567"      | false
        "RI"    | "AB12345"       | false
        "RI"    | "AB123456"      | false
        "RI"    | "AB1234567"     | false
        "RI"    | "ABCDEFG"       | false



        "CA"    | "1234567"             | false
        "CA"    | "12345678"            | false
        "CA"    | "A123456"             | false
        "CA"    | "A1234567"            | true
        "CA"    | "A12345678"           | false
        "CA"    | "AB123456"            | false
        "CA"    | "AB1234567"           | false
        "CA"    | "ABCDEFGH"            | false

        "DE"    | "1"                   | true
        "DE"    | "12"                  | true
        "DE"    | "123"                 | true
        "DE"    | "1234"                | true
        "DE"    | "12345"               | true
        "DE"    | "123456"              | true
        "DE"    | "1234567"             | true
        "DE"    | "12345678"            | false
        "DE"    | "A1"                  | false
        "DE"    | "A12"                 | false
        "DE"    | "A123"                | false
        "DE"    | "A1234"               | false
        "DE"    | "A12345"              | false
        "DE"    | "A123456"             | false
        "DE"    | "A1234567"            | false
        "DE"    | "A"                   | false
        "DE"    | "AB"                  | false
        "DE"    | "ABC"                 | false
        "DE"    | "ABCD"                | false
        "DE"    | "ABCDE"               | false
        "DE"    | "ABCDEF"              | false
        "DE"    | "ABCDEFG"             | false

        "DC"    | "123456"              | false
        "DC"    | "1234567"             | true
        "DC"    | "12345678"            | false
        "DC"    | "123456789"           | true
        "DC"    | "1234567890"          | false
        "DC"    | "A123456"             | false
        "DC"    | "A1234567"            | false
        "DC"    | "A12345678"           | false
        "DC"    | "A123456789"          | false
        "DC"    | "ABCDEFG"             | false
        "DC"    | "ABCDEFGH"            | false
        "DC"    | "ABCDEFGHI"           | false

        "ID"    | "12345678"            | false
        "ID"    | "123456789"           | true
        "ID"    | "1234567890"          | false
        "ID"    | "A12345678"           | false
        "ID"    | "A123456789"          | false
        "ID"    | "A123456A"            | false
        "ID"    | "AB12345A"            | false
        "ID"    | "AB123456"            | false
        "ID"    | "AB123456A"           | true
        "ID"    | "ABC123456A"          | false
        "ID"    | "AB1234567A"          | false
        "ID"    | "AB123456AB"          | false
        "ID"    | "ABCDEFGHI"           | false

        "IL"    | "12345678901"         | false
        "IL"    | "123456789012"        | false
        "IL"    | "A1234567890"         | false
        "IL"    | "A12345678901"        | true
        "IL"    | "A123456789012"       | false
        "IL"    | "AB1234576890"        | false
        "IL"    | "AB12345768901"       | false
        "IL"    | "ABCDEFGHIJKL"        | false

        "KS"    | "12345678"            | false
        "KS"    | "123456789"           | false
        "KS"    | "K1234567"            | false
        "KS"    | "A12345678"           | false
        "KS"    | "J12345678"           | false
        "KS"    | "K12345678"           | true
        "KS"    | "L12345678"           | false
        "KS"    | "K123456789"          | false
        "KS"    | "KB1234567"           | false
        "KS"    | "KB12345678"          | false
        "KS"    | "KBCDEFGHI"           | false

        "LA"    | "12345678"            | false
        "LA"    | "123456789"           | false
        "LA"    | "01234567"            | false
        "LA"    | "A12345678"           | false
        "LA"    | "012345678"           | true
        "LA"    | "Z12345678"           | false
        "LA"    | "0123456789"          | false
        "LA"    | "A123456789"          | false
        "LA"    | "ABCDEFGHI"           | false

        "MA"    | "12345678"            | false
        "MA"    | "123456789"           | false
        "MA"    | "A1234567"            | false
        "MA"    | "A12345678"           | true
        "MA"    | "A123456789"          | false
        "MA"    | "AB1234567"           | false
        "MA"    | "AB12345678"          | false
        "MA"    | "ABCDEFGHI"           | false

        "MO"    | "12345"               | false
        "MO"    | "123456"              | false
        "MO"    | "1234567"             | false
        "MO"    | "12345678"            | false
        "MO"    | "123456789"           | true
        "MO"    | "1234567890"          | false
        "MO"    | "A1234"               | false
        "MO"    | "A12345"              | true
        "MO"    | "A123456"             | true
        "MO"    | "A1234567"            | true
        "MO"    | "A12345678"           | true
        "MO"    | "A123456789"          | true
        "MO"    | "A1234567890"         | false
        "MO"    | "AB1234"              | false
        "MO"    | "AB12345"             | false
        "MO"    | "AB123456"            | false
        "MO"    | "AB1234567"           | false
        "MO"    | "AB12345678"          | false
        "MO"    | "AB123456789"         | false
        "MO"    | "ABCDEF"              | false
        "MO"    | "ABCDEFG"             | false
        "MO"    | "ABCDEFGH"            | false
        "MO"    | "ABCDEFGHI"           | false
        "MO"    | "ABCDEFGHIJ"          | false

        "MT"    | "12345678"            | false
        "MT"    | "123456789"           | true
        "MT"    | "1234567890"          | false
        "MT"    | "12345678901"         | false
        "MT"    | "123456789012"        | false
        "MT"    | "1234567890123"       | true
        "MT"    | "12345678901234"      | false
        "MT"    | "A12345678"           | false
        "MT"    | "A123456789"          | false
        "MT"    | "A1234567890"         | false
        "MT"    | "A12345678901"        | false
        "MT"    | "A123456789012"       | false
        "MT"    | "A1234567890123"      | false
        "MT"    | "ABCDEFGHI"           | false
        "MT"    | "ABCDEFGHIJ"          | false
        "MT"    | "ABCDEFGHIJK"         | false
        "MT"    | "ABCDEFGHIJKL"        | false
        "MT"    | "ABCDEFGHIJKLM"       | false

        "NE"    | "12"                  | false
        "NE"    | "123"                 | false
        "NE"    | "1234"                | false
        "NE"    | "12345"               | false
        "NE"    | "123456"              | false
        "NE"    | "1234567"             | false
        "NE"    | "12345678"            | false
        "NE"    | "123456789"           | false
        "NE"    | "A12"                 | false
        "NE"    | "A123"                | true
        "NE"    | "A1234"               | true
        "NE"    | "A12345"              | true
        "NE"    | "A123456"             | true
        "NE"    | "A1234567"            | true
        "NE"    | "A12345678"           | true
        "NE"    | "A123456789"          | false
        "NE"    | "AB12"                | false
        "NE"    | "AB123"               | false
        "NE"    | "AB1234"              | false
        "NE"    | "AB12345"             | false
        "NE"    | "AB123456"            | false
        "NE"    | "AB1234567"           | false
        "NE"    | "AB12345678"          | false
        "NE"    | "ABCD"                | false
        "NE"    | "ABCDE"               | false
        "NE"    | "ABCDEF"              | false
        "NE"    | "ABCDEFG"             | false
        "NE"    | "ABCDEFGH"            | false
        "NE"    | "ABCDEFGHI"           | false

        "NH"    | "123456789"           | false
        "NH"    | "1234567890"          | false
        "NH"    | "12345678901"         | false
        "NH"    | "1ABC12345"           | false
        "NH"    | "12AB12345"           | false
        "NH"    | "12ABC1234"           | false
        "NH"    | "12ABC12345"          | true
        "NH"    | "123ABC12345"         | false
        "NH"    | "12ABCD12345"         | false
        "NH"    | "12ABC123456"         | false
        "NH"    | "ABCDEFGHIJ"          | false

        "NJ"    | "12345678901234"      | false
        "NJ"    | "123456789012345"     | false
        "NJ"    | "A1234567890123"      | false
        "NJ"    | "A12345678901234"     | true
        "NJ"    | "A123456789012345"    | false
        "NJ"    | "AB1234567890123"     | false
        "NJ"    | "AB12345678901234"    | false
        "NJ"    | "ABCDEFGHIJKLMNO"     | false

        "NC"    | "1"                   | true
        "NC"    | "12"                  | true
        "NC"    | "123"                 | true
        "NC"    | "1234"                | true
        "NC"    | "12345"               | true
        "NC"    | "123456"              | true
        "NC"    | "1234567"             | true
        "NC"    | "12345678"            | true
        "NC"    | "123456789"           | true
        "NC"    | "1234567890"          | true
        "NC"    | "12345678901"         | true
        "NC"    | "123456789012"        | true
        "NC"    | "1234567890123"       | false
        "NC"    | "A1"                  | false
        "NC"    | "A12"                 | false
        "NC"    | "A123"                | false
        "NC"    | "A1234"               | false
        "NC"    | "A12345"              | false
        "NC"    | "A123456"             | false
        "NC"    | "A1234567"            | false
        "NC"    | "A12345678"           | false
        "NC"    | "A123456789"          | false
        "NC"    | "A1234567890"         | false
        "NC"    | "A12345678901"        | false
        "NC"    | "A123456789012"       | false
        "NC"    | "A"                   | false
        "NC"    | "AB"                  | false
        "NC"    | "ABC"                 | false
        "NC"    | "ABCD"                | false
        "NC"    | "ABCDE"               | false
        "NC"    | "ABCDEF"              | false
        "NC"    | "ABCDEFG"             | false
        "NC"    | "ABCDEFGH"            | false
        "NC"    | "ABCDEFGHI"           | false
        "NC"    | "ABCDEFGHIJ"          | false
        "NC"    | "ABCDEFGHIJK"         | false
        "NC"    | "ABCDEFGHIJKL"        | false

        "ND"    | "12345678"            | false
        "ND"    | "123456789"           | true
        "ND"    | "1234567890"          | false
        "ND"    | "A12345678"           | false
        "ND"    | "A123456789"          | false
        "ND"    | "AB1234567"           | false
        "ND"    | "AB12345678"          | false
        "ND"    | "AB123456789"         | false
        "ND"    | "ABC12345"            | false
        "ND"    | "ABC123456"           | true
        "ND"    | "ABC1234567"          | false
        "ND"    | "ABC12345678"         | false
        "ND"    | "ABC123456789"        | false
        "ND"    | "ABCD12345"           | false
        "ND"    | "ABCD123456"          | false
        "ND"    | "ABCDEFGHI"           | false

        "OH"    | "123456"              | false
        "OH"    | "1234567"             | false
        "OH"    | "12345678"            | false
        "OH"    | "A12345"              | false
        "OH"    | "A123456"             | false
        "OH"    | "A1234567"            | false
        "OH"    | "A12345678"           | false
        "OH"    | "AB12345"             | false
        "OH"    | "AB123456"            | true
        "OH"    | "AB1234567"           | false
        "OH"    | "ABCDEFGH"            | false

        "OK"    | "12345678"            | false
        "OK"    | "123456789"           | true
        "OK"    | "12345678901"         | false
        "OK"    | "A12345678"           | false
        "OK"    | "1234567890"          | true
        "OK"    | "A123456789"          | true
        "OK"    | "AB12345678"          | true
        "OK"    | "ABC1234567"          | true
        "OK"    | "ABCD123456"          | true
        "OK"    | "ABCDE12345"          | true
        "OK"    | "ABCDEF1234"          | true
        "OK"    | "ABCDEFG123"          | true
        "OK"    | "ABCDEFGH12"          | true
        "OK"    | "ABCDEFGHI1"          | true
        "OK"    | "ABCDEFGHIJ"          | true
        "OK"    | "1ABCDEFGHI"          | true
        "OK"    | "12ABCDEFGH"          | true
        "OK"    | "123ABCDEFG"          | true
        "OK"    | "1234ABCDEF"          | true
        "OK"    | "12345ABCDE"          | true
        "OK"    | "123456ABCD"          | true
        "OK"    | "1234567ABC"          | true
        "OK"    | "12345678AB"          | true
        "OK"    | "123456789A"          | true
        "OK"    | "A1A1A1A1A1"          | true
        "OK"    | "1A1A1A1A1A"          | true
        "OK"    | "AB12AB12AB"          | true
        "OK"    | "12AB12AB12"          | true
        "OK"    | "ABC123ABC1"          | true
        "OK"    | "123ABC123A"          | true
        "OK"    | "ABCD1234AB"          | true
        "OK"    | "1234ABCD12"          | true
        "OK"    | "123456789*"          | false
        "OK"    | "123456789-"          | false
        "OK"    | "123456789/"          | false
        "OK"    | "A1234567890"         | false
        "OK"    | "ABCDEFGHI"           | false
        "OK"    | "ABCDEFGHIJK"         | false

        "PA"    | "1234567"             | false
        "PA"    | "12345678"            | true
        "PA"    | "123456789"           | false
        "PA"    | "A1234567"            | false
        "PA"    | "A12345678"           | false
        "PA"    | "ABCDEFGH"            | false

        "SC"    | "1234567890"          | false
        "SC"    | "12345678901"         | true
        "SC"    | "123456789012"        | false
        "SC"    | "A1234567890"         | false
        "SC"    | "A12345678901"        | false
        "SC"    | "ABCDEFGHIJK"         | false

        "SD"    | "12345"               | false
        "SD"    | "123456"              | true
        "SD"    | "1234567"             | true
        "SD"    | "12345678"            | true
        "SD"    | "123456789"           | true
        "SD"    | "1234567890"          | false
        "SD"    | "A12345"              | false
        "SD"    | "A123456"             | false
        "SD"    | "A1234567"            | false
        "SD"    | "A12345678"           | false
        "SD"    | "A123456789"          | false
        "SD"    | "ABCDEF"              | false
        "SD"    | "ABCDEFG"             | false
        "SD"    | "ABCDEFGH"            | false
        "SD"    | "ABCDEFGHI"           | false

        "TN"    | "123456"              | false
        "TN"    | "1234567"             | true
        "TN"    | "12345678"            | true
        "TN"    | "123456789"           | true
        "TN"    | "1234567890"          | false
        "TN"    | "A123456"             | false
        "TN"    | "A1234567"            | false
        "TN"    | "A12345678"           | false
        "TN"    | "A123456789"          | false
        "TN"    | "ABCDEFG"             | false
        "TN"    | "ABCDEFGH"            | false
        "TN"    | "ABCDEFGHI"           | false

        "TX"    | "123456"              | false
        "TX"    | "1234567"             | true
        "TX"    | "12345678"            | true
        "TX"    | "123456789"           | false
        "TX"    | "A123456"             | false
        "TX"    | "A1234567"            | false
        "TX"    | "A12345678"           | false
        "TX"    | "ABCDEFG"             | false
        "TX"    | "ABCDEFGH"            | false

        "UT"    | "123"                 | false
        "UT"    | "1234"                | true
        "UT"    | "12345"               | true
        "UT"    | "123456"              | true
        "UT"    | "1234567"             | true
        "UT"    | "12345678"            | true
        "UT"    | "123456789"           | true
        "UT"    | "1234567890"          | true
        "UT"    | "12345678901"         | false
        "UT"    | "A123"                | false
        "UT"    | "A1234"               | false
        "UT"    | "A12345"              | false
        "UT"    | "A123456"             | false
        "UT"    | "A1234567"            | false
        "UT"    | "A12345678"           | false
        "UT"    | "A123456789"          | false
        "UT"    | "A1234567890"         | false
        "UT"    | "ABCD"                | false
        "UT"    | "ABCDE"               | false
        "UT"    | "ABCDEF"              | false
        "UT"    | "ABCDEFG"             | false
        "UT"    | "ABCDEFGH"            | false
        "UT"    | "ABCDEFGHI"           | false
        "UT"    | "ABCDEFGHIJ"          | false

        "VT"    | "1234567"             | false
        "VT"    | "12345678"            | true
        "VT"    | "123456789"           | false
        "VT"    | "A1234567"            | false
        "VT"    | "A12345678"           | false
        "VT"    | "123456A"             | false
        "VT"    | "1234567A"            | true
        "VT"    | "12345678A"           | false
        "VT"    | "1234567"             | false
        "VT"    | "ABCDEFGH"            | false

        "WA"    | "12345678901"         | false
        "WA"    | "123456789012"        | false
        "WA"    | "1234567890123"       | false
        "WA"    | "ABCDEFG12345"        | true
        "WA"    | "ABCDEFG1234A"        | true
        "WA"    | "ABCDEFG123A1"        | true
        "WA"    | "ABCDEFG123AB"        | true
        "WA"    | "ABCDEF*12345"        | true
        "WA"    | "ABCDEF*1234A"        | true
        "WA"    | "ABCDEF*123A1"        | true
        "WA"    | "ABCDEF*123AB"        | true
        "WA"    | "ABCD*AB12345"        | true
        "WA"    | "ABCD*AB1234A"        | true
        "WA"    | "ABCD*AB123A1"        | true
        "WA"    | "ABCD*AB123AB"        | true
        "WA"    | "ABCD*A*12345"        | true
        "WA"    | "ABCD*A*1234A"        | true
        "WA"    | "ABCD*A*123A1"        | true
        "WA"    | "ABCD*A*123AB"        | true
        "WA"    | "ABC*ABC12345"        | true
        "WA"    | "ABC*ABC1234A"        | true
        "WA"    | "ABC*ABC123A1"        | true
        "WA"    | "ABC*ABC123AB"        | true
        "WA"    | "ABC*AB*12345"        | true
        "WA"    | "ABC*AB*1234A"        | true
        "WA"    | "ABC*AB*123A1"        | true
        "WA"    | "ABC*AB*123AB"        | true
        "WA"    | "ABC**AB12345"        | true
        "WA"    | "ABC**AB1234A"        | true
        "WA"    | "ABC**AB123A1"        | true
        "WA"    | "ABC**AB123AB"        | true
        "WA"    | "ABC**A*12345"        | true
        "WA"    | "ABC**A*1234A"        | true
        "WA"    | "ABC**A*123A1"        | true
        "WA"    | "ABC**A*123AB"        | true
        "WA"    | "AB*ABCD12345"        | true
        "WA"    | "AB*ABCD1234A"        | true
        "WA"    | "AB*ABCD123A1"        | true
        "WA"    | "AB*ABCD123AB"        | true
        "WA"    | "AB*ABC*12345"        | true
        "WA"    | "AB*ABC*1234A"        | true
        "WA"    | "AB*ABC*123A1"        | true
        "WA"    | "AB*ABC*123AB"        | true
        "WA"    | "AB*A*AB12345"        | true
        "WA"    | "AB*A*AB1234A"        | true
        "WA"    | "AB*A*AB123A1"        | true
        "WA"    | "AB*A*AB123AB"        | true
        "WA"    | "AB*A*A*12345"        | true
        "WA"    | "AB*A*A*1234A"        | true
        "WA"    | "AB*A*A*123A1"        | true
        "WA"    | "AB*A*A*123AB"        | true
        "WA"    | "AB**ABC12345"        | true
        "WA"    | "AB**ABC1234A"        | true
        "WA"    | "AB**ABC123A1"        | true
        "WA"    | "AB**ABC123AB"        | true
        "WA"    | "AB**AB*12345"        | true
        "WA"    | "AB**AB*1234A"        | true
        "WA"    | "AB**AB*123A1"        | true
        "WA"    | "AB**AB*123AB"        | true
        "WA"    | "AB***AB12345"        | true
        "WA"    | "AB***AB1234A"        | true
        "WA"    | "AB***AB123A1"        | true
        "WA"    | "AB***AB123AB"        | true
        "WA"    | "AB***A*12345"        | true
        "WA"    | "AB***A*1234A"        | true
        "WA"    | "AB***A*123A1"        | true
        "WA"    | "AB***A*123AB"        | true
        "WA"    | "1ABCDEF12345"        | false
        "WA"    | "A1ABCDE12345"        | false
        "WA"    | "AB1ABCD12345"        | false
        "WA"    | "ABC1ABC12345"        | false
        "WA"    | "ABCD1AB12345"        | false
        "WA"    | "ABCDE1A12345"        | false
        "WA"    | "ABCDEF123456"        | false
        "WA"    | "ABCDEFGH1234"        | false
        "WA"    | "ABCDEFG1A123"        | false
        "WA"    | "ABCDEFG12A12"        | false
        "WA"    | "*ABCDEF12345"        | false
        "WA"    | "A*ABCDE12345"        | false
        "WA"    | "ABCDE*A12345"        | false
        "WA"    | "ABCDEFG*1234"        | false
        "WA"    | "ABCDEFG1*123"        | false
        "WA"    | "ABCDEFG12*12"        | false
        "WA"    | "ABCDEFG123*4"        | false
        "WA"    | "ABCDEFG1234*"        | false
        "WA"    | "1A***A*123AB"        | false
        "WA"    | "A1***A*123AB"        | false
        "WA"    | "AB1**A*123AB"        | false
        "WA"    | "AB*1*A*123AB"        | false
        "WA"    | "AB**1A*123AB"        | false
        "WA"    | "AB***1*123AB"        | false
        "WA"    | "AB***A1234AB"        | false
        "WA"    | "AB***A*A12AB"        | false
        "WA"    | "AB***A*1A1AB"        | false
        "WA"    | "AB***A*12ABC"        | false
        "WA"    | "*A***A*123AB"        | false
        "WA"    | "A****A*123AB"        | false
        "WA"    | "AB*****123AB"        | false
        "WA"    | "AB***A**12AB"        | false
        "WA"    | "AB***A*1*1AB"        | false
        "WA"    | "AB***A*12*AB"        | false
        "WA"    | "AB***A*123*A"        | false
        "WA"    | "AB***A*123A*"        | false
        "WA"    | "-A***A*123AB"        | false
        "WA"    | "A-***A*123AB"        | false
        "WA"    | "AB-**A*123AB"        | false
        "WA"    | "AB*-*A*123AB"        | false
        "WA"    | "AB**-A*123AB"        | false
        "WA"    | "AB***-*123AB"        | false
        "WA"    | "AB***A-123AB"        | false
        "WA"    | "AB***A*-12AB"        | false
        "WA"    | "AB***A*1-1AB"        | false
        "WA"    | "AB***A*12-AB"        | false
        "WA"    | "AB***A*123-A"        | false
        "WA"    | "AB***A*123A-"        | false
        "WA"    | "ABCDEFGHIJK"         | false
        "WA"    | "ABCDEFGHIJKL"        | false
        "WA"    | "ABCDEFGHIJKLM"       | false

        "WV"    | "123456"              | false
        "WV"    | "12345678"            | false
        "WV"    | "1234567"             | true
        "WV"    | "A123456"             | true
        "WV"    | "AB12345"             | true
        "WV"    | "ABC1234"             | true
        "WV"    | "ABCD123"             | true
        "WV"    | "ABCDE12"             | true
        "WV"    | "ABCDEF1"             | true
        "WV"    | "ABCDEFG"             | true
        "WV"    | "1ABCDEF"             | true
        "WV"    | "12ABCDE"             | true
        "WV"    | "123ABCD"             | true
        "WV"    | "1234ABC"             | true
        "WV"    | "12345AB"             | true
        "WV"    | "123456A"             | true
        "WV"    | "A1A1A1A"             | true
        "WV"    | "1A1A1A1"             | true
        "WV"    | "AB12AB1"             | true
        "WV"    | "12AB12A"             | true
        "WV"    | "ABC123A"             | true
        "WV"    | "123ABC1"             | true
        "WV"    | "123456*"             | false
        "WV"    | "123456-"             | false
        "WV"    | "123456/"             | false
        "WV"    | "A1234567"            | false
        "WV"    | "A12345678"           | false
        "WV"    | "ABCDEF"              | false
        "WV"    | "ABCDEFGH"            | false

        "WI"    | "1234567890123"       | false
        "WI"    | "12345678901234"      | false
        "WI"    | "A123456789012"       | false
        "WI"    | "A1234567890123"      | true
        "WI"    | "A12345678901234"     | false
        "WI"    | "ABCDEFGHIJKLMN"      | false

        "WY"    | "12345678"            | false
        "WY"    | "123456789"           | true
        "WY"    | "1234567890"          | false
        "WY"    | "1-12345678"          | false
        "WY"    | "12-1234567"          | false
        "WY"    | "123-123456"          | false
        "WY"    | "1234-12345"          | false
        "WY"    | "12345-1234"          | false
        "WY"    | "123456-123"          | true
        "WY"    | "123456A123"          | false
        "WY"    | "123456*123"          | false
        "WY"    | "1234567-12"          | false
        "WY"    | "12345678-1"          | false
        "WY"    | "A12345678"           | false
        "WY"    | "A123456789"          | false
        "WY"    | "ABCDEFGHI"           | false
        "WY"    | "ABCDEFGHIJ"          | false

        validNotValid = passed ? "valid" : "not valid"
    }
}
