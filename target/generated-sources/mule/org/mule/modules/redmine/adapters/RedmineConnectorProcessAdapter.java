
package org.mule.modules.redmine.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.redmine.RedmineConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>RedmineConnectorProcessAdapter</code> is a wrapper around {@link RedmineConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-03-30T04:57:42-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RedmineConnectorProcessAdapter
    extends RedmineConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<RedmineConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, RedmineConnectorCapabilitiesAdapter> getProcessTemplate() {
        final RedmineConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,RedmineConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, RedmineConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, RedmineConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
