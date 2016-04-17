US Driver's License Regex Repository
====================================
Sourced from https://ntsi.com/drivers-license-format/
Known to be valid as of 2016-04-16.


Installation
------------

Install with composer: `composer require adambullmer/usdl-regex`


Usage
-----

```php
$options = array(
    'verbose'         => FALSE,
    'caseInsensitive' => FALSE,
);
$validator = new USDLRegex/Validator($options);

$validator->validate('TX', '12345678');  // TRUE
$validator->validate('TX', '123456789'); // FALSE
```
