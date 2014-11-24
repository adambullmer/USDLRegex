US Driver's License Regex Repository
=========

Below is a callback function for validating a dl field using CodeIgniter's `form_validation->set_rules()` function. If you are just interested in the array itself, feel free to copy and paste into your own code.

    /********************************************************
     * @DESCRIPTION: validation for the format of a driver's 
     *   license list as of 2012 US Driver's Licenses formats
     * @author: Adam Bullmer
     * @date: 04/04/2013
     * 
     * @PARAM: $string, automatic input from form_validation()
     * @EXPECTED-INPUT: alpha-numeric, trimmed
     * 
     * @REQUIREMENTS: It is required to validate the DL State 
     * field FIRST in order for us to choose which regex rules
     * we will use. 
     * @FIELD: 'dl_state'
     * @FIELD-VALUE: 2 uppercase character state abbreviation
     ********************************************************/
    public function dl_format($string) {
      $dlformat = array(
        'AL'=>"^[0-9]{1,7}$", //1-7Numeric
        'AK'=>"^[0-9]{1,7}$", //1-7Numeric
        'AZ'=>"^([a-zA-Z0-9][0-9]{8}|[a-zA-Z]{2}[0-9]{2,5})$", //1AlphaNumeric+8Numeric or 2Alpha+2-5Numeric
        'AR'=>"^[0-9]{4,9}$", //4-9Numeric
        'CA'=>"^[a-zA-Z][0-9]{7}$", //1Alpha+7Numeric
        'CO'=>"^([0-9]{9}|[a-zA-Z][a-zA-Z0-9][0-9]{2,5})$", //9Numeric or 1Alpha+1AlphaNumeric+2-5Numeric
        'CT'=>"^[0-9]{9}$", //9Numeric
        'DE'=>"^[0-9]{1,7}$", //1-7Numeric
        'DC'=>"^(([0-9]{7})|([0-9]{9}))$", //7Numeric or 9Numeric
        'FL'=>"^[a-zA-Z][0-9]{12}$", //1Alpha+12Numeric
        'GA'=>"^[0-9]{7,9}$", //7-9Numeric
        'HI'=>"^[a-zA-Z0-9][0-9]{8}$", //1AlphaNumeric+8Numeric
        'ID'=>"^([a-zA-Z]{2}[0-9]{6}[a-zA-Z]|[0-9]{9})$", //2Alpha+6Numeric+1Alpha or 9Numeric
        'IL'=>"^[a-zA-Z][0-9]{11,12}$", //1Alpha+11-12Numeric
        'IN'=>"^[a-zA-Z0-9]?[0-9]{9}$", //0-1AlphaNumeric+9Numeric
        'IA'=>"^([0-9]{9}|[0-9]{3}[a-zA-Z]{2}[0-9]{4})$", //9Numeric or 3Numeric+2Alpha+4Numeric
        'KS'=>"^([a-zA-Z][0-9][a-zA-Z][0-9][a-zA-Z]|[a-zA-Z0-9][0-9]{8})$", //1Alpha+1Numeric+1Alpha+1Numeric+1Alpha or 1AlphaNumeric+8Numeric
        'KY'=>"^([a-zA_Z][0-9]{8,9}|[0-9]{9})$", //1Alpha+8-9Numeric or 9Numeric
        'LA'=>"^[0-9]{1,9}$", //1-9Numeric
        'ME'=>"^[0-9]{7}[a-zA-Z0-9]?$", //7Numeric+0-1AlphaNumeric
        'MD'=>"^[a-zA-Z][0-9]{12}$", //1Alpha+12Numeric
        'MA'=>"^[a-zA-Z0-9][0-9]{8}$", //1AlphaNumeric+8Numeric
        'MI'=>"^[a-zA-Z]([0-9]{10}|[0-9]{12})$", //1Alpha+(10 or 12)Numeric
        'MN'=>"^[a-zA-Z][0-9]{12}$", //1Alpha+12Numeric
        'MS'=>"^[0-9]{9}$", //9Numeric
        'MO'=>"^([a-zA-Z][0-9]{5,9}|[a-zA-Z][0-9]{6}[R]|[0-9]{8}[a-zA-Z0-9][a-zA-Z]|[0-9]{9})$", //1Alpha+5-9Numeric or 1Alpha+6Numeric+R or 8Numeric+1AlphaNumeric+1Alpha or 9Numeric
        'MT'=>"^([a-zA-Z0-9][0-9]{8}|[0-9]{13,14})$", //1Alpha+8Numeric or 9Numeric or 13-14Numeric
        'NE'=>"^[0-9]{1,7}$", //1-7Numeric
        'NV'=>"^([0-9]{9,10}|[0-9]{12}|[X][0-9]{8})$", //9-10Numeric or 12Numeric or X+8Numeric
        'NH'=>"^[0-9]{2}[a-zA-Z]{3}[0-9]{5}$", //2Numeric+3Alpha+5Numeric
        'NJ'=>"^[a-zA-Z][0-9]{14}$", //1Alpha+14Numeric
        'NM'=>"^[0-9]{8,9}$", //8-9Numeric
        'NY'=>"^([a-zA-Z]([0-9]{7}|[0-9]{18})|[0-9]{8,9}|[0-9]{16}|[a-zA-Z]{8})$", //1Alpha+(7 or 18)Numeric or 8-9Numeric or 16 Numeric or 8Alpha
        'NC'=>"^[0-9]{1,12}$", //1-12Numeric
        'ND'=>"^([a-zA-Z]{3}[0-9]{6}|[0-9]{9})$", //3Alpha+6Numeric or 9Numeric
        'OH'=>"^([a-zA-Z][a-zA-Z0-9][0-9]{3,7}|[0-9]{8})$", //1Alpha+1AlphaNumeric+3-7Numeric or 8Numeric
        'OK'=>"^[a-zA-Z]?[0-9]{9}$", //0-1Alpha+9Numeric
        'OR'=>"^[0-9]{1,9}$", //1-9Numeric
        'PA'=>"^[0-9]{8}$", //8Numeric
        'RI'=>"^[a-zA-Z0-9][0-9]{6}$", //1AlphaNumeric+6Numeric
        'SC'=>"^[0-9]{5,11}$", //5-11Numeric
        'SD'=>"^([0-9]{6,10}|[0-9]{12})$", //6-10Numeric or 12Numeric
        'TN'=>"^[0-9]{7,9}$", //7-9Numeric
        'TX'=>"^[0-9]{7,8}$", //7-8Numeric
        'UT'=>"^[0-9]{4,10}$", //4-10Numeric
        'VT'=>"^[0-9]{7}[0-9A]$", //7Numeric+(1Numeric or A)
        'VA'=>"^([a-zA-Z][0-9]{9,11}|[0-9]{9})$", //1Alpha+9-11Numeric or 9Numeric
        'WA'=>"^[a-zA-Z][a-zA-Z0-9\*]{11}$", //1Alpha+11(Alpha, Numeric, or *)
        'WV'=>"^([0-9]{7}|[a-zA-Z]{1,2}[0-9]{5,6})$", //7Numeric or 1-2Alpha+5-6Numeric
        'WI'=>"^[a-zA-Z][0-9]{13}$", //1Alpha+13Numeric
        'WY'=>"^[0-9]{9,10}$", //9-10Numeric
      );
		
      if (!preg_match('/'.$dlformat[$this->input->post('dlstate')].'/', $string)) {
        $this->form_validation->set_message('dl_format', 'That does not appear to be a valid Driver\'s License');
        return FALSE;
      }
      else
        return TRUE;
    }
