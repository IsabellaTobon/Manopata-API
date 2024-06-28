package com.manopata.api.roles.interfaces.queries;

public class RoleQueries
{
    public static final String CHECK_TOKEN_PERMISSION =
                    """
                    select count(*)
                    from roleendpoint
                    where role = :role
                    and endpoint = :endpoint
                    and status = true
                    """;
}
