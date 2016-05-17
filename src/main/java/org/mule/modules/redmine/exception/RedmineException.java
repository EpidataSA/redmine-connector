/**
 * (c) 2003-2016 MuleSoft, Inc. The software in this package is
 * published under the terms of the CPAL v1.0 license, a copy of which
 * has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.redmine.exception;

public class RedmineException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RedmineException() {
        super();
    }

    public RedmineException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedmineException(String message) {
        super(message);
    }

    public RedmineException(Throwable cause) {
        super(cause);
    }
}
