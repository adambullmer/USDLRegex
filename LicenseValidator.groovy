package validate.basic
import model.State

class LicenseValidator {
    static boolean checkLicense(State licenseState, String licenseNumber){
        if(!licenseState) return false
        switch(licenseState.abbreviation){
            case 'AL': return licenseNumber.matches(/^[0-9]{1,7}$/) //1-7Numeric
            case 'AK': return licenseNumber.matches(/^[0-9]{1,7}$/) //1-7Numeric
            case 'AZ': return licenseNumber.matches(/^([a-zA-Z0-9][0-9]{8}|[a-zA-Z]{2}[0-9]{2,5})$/) //1AlphaNumeric+8Numeric or 2Alpha+2-5Numeric
            case 'AR': return licenseNumber.matches(/^[0-9]{4,9}$/) //4-9Numeric
            case 'CA': return licenseNumber.matches(/^[a-zA-Z][0-9]{7}$/) //1Alpha+7Numeric
            case 'CO': return licenseNumber.matches(/^([0-9]{9}|[a-zA-Z][a-zA-Z0-9][0-9]{2,5})$/) //9Numeric or 1Alpha+1AlphaNumeric+2-5Numeric
            case 'CT': return licenseNumber.matches(/^[0-9]{9}$/) //9Numeric
            case 'DE': return licenseNumber.matches(/^[0-9]{1,7}$/) //1-7Numeric
            case 'DC': return licenseNumber.matches(/^([0-9]{7})|([0-9]{9})$/) //7Numeric or 9Numeric
            case 'FL': return licenseNumber.matches(/^[a-zA-Z][0-9]{12}$/) //1Alpha+12Numeric
            case 'GA': return licenseNumber.matches(/^[0-9]{7,9}$/) //7-9Numeric
            case 'HI': return licenseNumber.matches(/^[a-zA-Z0-9][0-9]{8}$/) //1AlphaNumeric+8Numeric
            case 'ID': return licenseNumber.matches(/^([a-zA-Z]{2}[0-9]{6}[a-zA-Z]|[0-9]{9})$/) //2Alpha+6Numeric+1Alpha or 9Numeric
            case 'IL': return licenseNumber.matches(/^[a-zA-Z][0-9]{11,12}$/) //1Alpha+11-12Numeric
            case 'IN': return licenseNumber.matches(/^[a-zA-Z0-9]?[0-9]{9}$/) //0-1AlphaNumeric+9Numeric
            case 'IA': return licenseNumber.matches(/^([0-9]{9}|[0-9]{3}[a-zA-Z]{2}[0-9]{4})$/) //9Numeric or 3Numeric+2Alpha+4Numeric
            case 'KS': return licenseNumber.matches(/^([a-zA-Z][0-9][a-zA-Z][0-9][a-zA-Z]|[a-zA-Z0-9][0-9]{8})$/) //1Alpha+1Numeric+1Alpha+1Numeric+1Alpha or 1AlphaNumeric+8Numeric
            case 'KY': return licenseNumber.matches(/^([a-zA_Z][0-9]{8,9}|[0-9]{9})$/) //1Alpha+8-9Numeric or 9Numeric
            case 'LA': return licenseNumber.matches(/^[0-9]{1,9}$/) //1-9Numeric
            case 'ME': return licenseNumber.matches(/^[0-9]{7}[a-zA-Z0-9]?$/) //7Numeric+0-1AlphaNumeric
            case 'MD': return licenseNumber.matches(/^[a-zA-Z][0-9]{12}$/) //1Alpha+12Numeric
            case 'MA': return licenseNumber.matches(/^[a-zA-Z0-9][0-9]{8}$/) //1AlphaNumeric+8Numeric
            case 'MI': return licenseNumber.matches(/^[a-zA-Z]([0-9]{10}|[0-9]{12})$/) //1Alpha+(10 or 12)Numeric
            case 'MN': return licenseNumber.matches(/^[a-zA-Z][0-9]{12}$/) //1Alpha+12Numeric
            case 'MS': return licenseNumber.matches(/^[0-9]{9}$/) //9Numeric
            case 'MO': return licenseNumber.matches(/^([a-zA-Z][0-9]{5,9}|[a-zA-Z][0-9]{6}[R]|[0-9]{8}[a-zA-Z0-9][a-zA-Z]|[0-9]{9})$/) //1Alpha+5-9Numeric or 1Alpha+6Numeric+R or 8Numeric+1AlphaNumeric+1Alpha or 9Numeric
            case 'MT': return licenseNumber.matches(/^([a-zA-Z0-9][0-9]{8}|[0-9]{13,14})$/) //1AlphaNumeric+8Numeric or 13-14Numeric
            case 'NE': return licenseNumber.matches(/^[0-9]{1,7}$/) //1-7Numeric
            case 'NV': return licenseNumber.matches(/^([0-9]{9,10}|[0-9]{12}|[X][0-9]{8})$/) //9-10Numeric or 12Numeric or X+8Numeric
            case 'NH': return licenseNumber.matches(/^[0-9]{2}[a-zA-Z]{3}[0-9]{5}$/) //2Numeric+3Alpha+5Numeric
            case 'NJ': return licenseNumber.matches(/^[a-zA-Z][0-9]{14}$/) //1Alpha+14Numeric
            case 'NM': return licenseNumber.matches(/^[0-9]{8,9}$/) //8-9Numeric
            case 'NY': return licenseNumber.matches(/^([a-zA-Z]([0-9]{7}|[0-9]{18})|[0-9]{8,9}|[0-9]{16}|[a-zA-Z]{8})$/) //1Alpha+(7 or 18)Numeric or 8-9Numeric or 16 Numeric or 8Alpha
            case 'NC': return licenseNumber.matches(/^[0-9]{1,12}$/) //1-12Numeric
            case 'ND': return licenseNumber.matches(/^([a-zA-Z]{3}[0-9]{6}|[0-9]{9})$/) //3Alpha+6Numeric or 9Numeric
            case 'OH': return licenseNumber.matches(/^([a-zA-Z][a-zA-Z0-9][0-9]{3,7}|[0-9]{8})$/) //1Alpha+1AlphaNumeric+3-7Numeric or 8Numeric
            case 'OK': return licenseNumber.matches(/^[a-zA-Z]?[0-9]{9}$/) //0-1Alpha+9Numeric
            case 'OR': return licenseNumber.matches(/^[0-9]{1,9}$/) //1-9Numeric
            case 'PA': return licenseNumber.matches(/^[0-9]{8}$/) //8Numeric
            case 'RI': return licenseNumber.matches(/^[a-zA-Z0-9][0-9]{6}$/) //1AlphaNumeric+6Numeric
            case 'SC': return licenseNumber.matches(/^[0-9]{5,11}$/) //5-11Numeric
            case 'SD': return licenseNumber.matches(/^([0-9]{6,10}|[0-9]{12})$/) //6-10Numeric or 12Numeric
            case 'TN': return licenseNumber.matches(/^[0-9]{7,9}$/) //7-9Numeric
            case 'TX': return licenseNumber.matches(/^[0-9]{7,8}$/) //7-8Numeric
            case 'UT': return licenseNumber.matches(/^[0-9]{4,10}$/) //4-10Numeric
            case 'VT': return licenseNumber.matches(/^[0-9]{7}[0-9A]$/) //7Numeric+(1Numeric or A)
            case 'VA': return licenseNumber.matches(/^([a-zA-Z][0-9]{9,11}|[0-9]{9})$/) //1Alpha+9-11Numeric or 9Numeric
            case 'WA': return licenseNumber.matches(/^[a-zA-Z][a-zA-Z0-9\*]{11}$/) //1Alpha+11(Alpha, Numeric, or *)
            case 'WV': return licenseNumber.matches(/^([0-9]{7}|[a-zA-Z]{1,2}[0-9]{5,6})$/) //7Numeric or 1-2Alpha+5-6Numeric
            case 'WI': return licenseNumber.matches(/^[a-zA-Z][0-9]{13}$/) //1Alpha+13Numeric
            case 'WY': return licenseNumber.matches(/^[0-9]{9,10}$/) //9-10Numeric
            default: return false
        }
    }
}
