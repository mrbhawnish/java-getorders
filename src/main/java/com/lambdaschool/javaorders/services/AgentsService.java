package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;

/**
 * The service that works with the Agent model.
 */

public interface AgentsService
{
    /**
     * Returns the Agent with the given primary key.
     *
     * @param id The primary key (long) of the agent you seek.
     * @return The given agent or throws an exception if not found.
     */

    Agent findAgentById(long id);
}
