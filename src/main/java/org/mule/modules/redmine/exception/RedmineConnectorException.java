/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.redmine.exception;

public class RedmineConnectorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RedmineConnectorException() {
        super();
    }

    public RedmineConnectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedmineConnectorException(String message) {
        super(message);
    }

    public RedmineConnectorException(Throwable cause) {
        super(cause);
    }
}
