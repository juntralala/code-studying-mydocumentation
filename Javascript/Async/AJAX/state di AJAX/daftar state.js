/** Daftar State
    +=======+===================+===============================================================+
    | Value | State             | Description                                                   |
    +-------+-------------------+---------------------------------------------------------------+
    | 0     | UNSET             | Client has been created. open() not called                    |
    | 1     | OPENED            | open() has been called                                        |
    | 2     | HEADERS_RECEIVED  | send() has been called, and headers and status are available  |
    | 3     | LOADING           | Downloading; responseText holds partial data                  |
    | 4     | DONE              | the operation is complete                                     |
    +=======+===================+===============================================================+
 */