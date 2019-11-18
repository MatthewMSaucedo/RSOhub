export interface LoginResponse {
    username: string;
    userType: string;
    loginSuccessful: boolean;
}

export interface LoginRequest {
    username: string;
    password: string;
}

export interface RegisterResponse {
    id: number;
    username: string;
    password: string;
    refUniversityId: number;
    userType: string;
}

export interface RegisterRequest {
    username: string;
    refUniversityId: number;
    password: string;
}

export interface CreateCommentRequest {
    refUserId: number;
    refEventId: number;
    text: string;
    rating: number;
    time: string;
}

export interface CreateCommentResponse {
    id: number;
    refUserId: number;
    refEventId: number;
    text: string;
    rating: number;
    time: string;
}

export interface DeleteCommentResponse {
    id: number;
    refUserId: number;
    refEventId: number;
    text: string;
    rating: number;
    time: string;
}

export interface ListCommentResponse {
    commentList: CreateCommentResponse[];
}

export interface Rso {
    id: number;
    name: string;
    isActive: boolean;
    memberCount: number;
    active: boolean;
}

export interface ListRsoByUserIdResponse {
    rsoList: Rso[];
}

export interface PetitionRequest {
    rsoName: string;
    userId: number;
}

export interface PetitionResponse {
    id: number;
    refRsoId: number;
    refUserId: number;
}

export interface JoinRequest {
    refRsoId: number;
    refUserId: number;
}

export interface JoinResponse {
    rso: Rso;
}

export interface Event {
    id: number;
    refLocationId: number;
    refRsoId: number;
    time: string;
    name: string;
    description: string;
    eventType: string;
}

export interface CreateEventRequest {
    refLocationId: number;
    refRsoId: number;
    time: string;
    name: string;
    description: string;
    eventType: string;
}

export interface CreateEventResponse {
    events: Event[];
}

export interface ListEventsOfUserResponse {
    eventList: Event[];
}

export interface ListEventsOfUserRequest {
    id: number;
    refUniversityId: number;
    username: string;
    password: string;
    userType: string;
}