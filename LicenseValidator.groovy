package validate.basic
import model.State

class LicenseValidator {
    static boolean checkLicense(State licenseState, String licenseNumber){
        if(!licenseState) return false
        switch(licenseState.abbreviation){
            case 'AL':
            case 'AK':
            case 'ME':
                return licenseNumber.matches(/^[0-9]{7}$/) // 7 Numeric
            case 'AR':
            case 'CO':
            case 'CT':
            case 'GA':
            case 'IA':
            case 'MS':
            case 'NM':
            case 'NY':
                return licenseNumber.matches(/^[0-9]{9}$/) // 9 Numeric
            case 'AZ':
            case 'HI':
            case 'KY':
            case 'VA':
                return licenseNumber.matches(/^[a-zA-Z0-9][0-9]{8}$/) // 1 AlphaNumeric + 8 Numeric
            case 'IN':
            case 'NV':
                return licenseNumber.matches(/^[0-9]{10}$/) // 10 Numeric
            case 'FL':
            case 'MD':
            case 'MI':
            case 'MN':
                return licenseNumber.matches(/^[a-zA-Z][0-9]{12}$/) // 1 Alpha + 12 Numeric
            case 'OR':
            case 'RI':
                return licenseNumber.matches(/^[a-zA-Z0-9][0-9]{6}$/) // 1 AlphaNumeric + 6 Numeric

            case 'CA': return licenseNumber.matches(/^[a-zA-Z][0-9]{7}$/) // 1 Alpha + 7 Numeric
            case 'DE': return licenseNumber.matches(/^[0-9]{1,7}$/) // 1-7 Numeric
            case 'DC': return licenseNumber.matches(/^([0-9]{7}|[0-9]{9})$/) // 7 Numeric or 9 Numeric
            case 'ID': return licenseNumber.matches(/^([0-9]{9}|[a-zA-Z]{2}[0-9]{6}[a-zA-Z])$/) // 9 Numeric or 2 Alpha + 6 Numeric + 1 Alpha
            case 'IL': return licenseNumber.matches(/^[a-zA-Z][0-9]{11}$/) // 1 Alpha + 11 Numeric
            case 'KS': return licenseNumber.matches(/^K[0-9]{8}$/) // 'K' + 8 Numeric
            case 'LA': return licenseNumber.matches(/^0[0-9]{8}$/) // '0' + 8 Numeric
            case 'MA': return licenseNumber.matches(/^[a-zA-Z][0-9]{8}$/) // 1 Alpha + 8 Numeric
            case 'MO': return licenseNumber.matches(/^([0-9]{9}|[a-zA-Z][0-9]{5,9})$/) // 9 Numeric or 1 Alpha + 5-9 Numeric
            case 'MT': return licenseNumber.matches(/^([0-9]{9}|[0-9]{13})$/) // 9 Numeric or 13 Numeric
            case 'NE': return licenseNumber.matches(/^[a-zA-Z][0-9]{3,8}$/) // 1 Alpha + 3-8 Numeric
            case 'NH': return licenseNumber.matches(/^[0-9]{2}[a-zA-Z]{3}[0-9]{5}$/) // 2 Numeric + 3 Alpha + 5 Numeric
            case 'NJ': return licenseNumber.matches(/^[a-zA-Z][0-9]{14}$/) // 1 Alpha + 14 Numeric
            case 'NC': return licenseNumber.matches(/^[0-9]{1,12}$/) // 1-12 Numeric
            case 'ND': return licenseNumber.matches(/^([0-9]{9}|[a-zA-Z]{3}[0-9]{6})$/) // 9 Numeric or 3 Alpha + 6 Numeric
            case 'OH': return licenseNumber.matches(/^[a-zA-Z]{2}[0-9]{6}$/) // 2 Alpha + 6 Numeric
            case 'OK': return licenseNumber.matches(/^([0-9]{9}|[a-zA-Z0-9]{10})$/) // 9 Numeric or 10 AlphaNumeric
            case 'PA': return licenseNumber.matches(/^[0-9]{8}$/) // 8 Numeric
            case 'SC': return licenseNumber.matches(/^[0-9]{11}$/) // 11 Numeric
            case 'SD': return licenseNumber.matches(/^[0-9]{6,9}$/) // 6-9 Numeric
            case 'TN': return licenseNumber.matches(/^[0-9]{7,9}$/) // 7-9 Numeric
            case 'TX': return licenseNumber.matches(/^[0-9]{8}$/) // 8 Numeric
            case 'UT': return licenseNumber.matches(/^[0-9]{4,10}$/) // 4-10 Numeric
            case 'VT': return licenseNumber.matches(/^[0-9]{7}[0-9a-zA-Z]$/) // 7 Numeric + 1 AlphaNumeric
            case 'WA': return licenseNumber.matches(/^[a-zA-Z]{2}[a-zA-Z\*]{3}[a-zA-Z][a-zA-Z\*][0-9]{3}[a-zA-Z0-9]{2}$/) // 2 Alpha + 3 (Alpha or *) + 1 Alpha + 1 (Alpha or *) + 3 Numeric + 2 AlphaNumeric
            case 'WV': return licenseNumber.matches(/^[a-zA-Z0-9]{7}$/) // 7 AlphaNumeric
            case 'WI': return licenseNumber.matches(/^[a-zA-Z][0-9]{13}$/) // 1 Alpha + 13 Numeric
            case 'WY': return licenseNumber.matches(/^[0-9]{6}-?[0-9]{3}$/) // 9 Numeric or 6 Numeric + '-' + 3 Numeric
            default: return false
        }
    }
}
